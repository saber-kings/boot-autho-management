package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysDeptMapper;
import com.yingxue.lesson.service.DeptService;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.utils.CodeUtil;
import com.yingxue.lesson.vo.req.DeptAddReqVO;
import com.yingxue.lesson.vo.req.DeptUpdateReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Saber污妖王
 * TODO: 部门业务层实现类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/21
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private UserService userService;

    @Override
    public List<SysDept> selectAll() {
        List<SysDept> list = sysDeptMapper.selectAll();
        list.forEach(s -> {
            SysDept parent = sysDeptMapper.selectByPrimaryKey(s.getPid());
            if (parent != null) {
                s.setPidName(parent.getName());
            }
        });
        return list;
    }

    @Override
    public List<DeptRespNodeVO> deptTreeList(String deptId) {
        List<SysDept> list = sysDeptMapper.selectAll();
        //要想去掉这个部门的叶子节点，直接在数据源移除这个部门即可
        if (!StringUtils.isEmpty(deptId) && !list.isEmpty()) {
            for (SysDept s : list) {
                if (s.getId().equals(deptId)) {
                    list.remove(s);
                    break;
                }
            }
        }
        DeptRespNodeVO respNodeVO = new DeptRespNodeVO();
        respNodeVO.setId("0");
        respNodeVO.setTitle("默认顶级部门");
        respNodeVO.setChildren(getTree(list));
        List<DeptRespNodeVO> result = new ArrayList<>();
        result.add(respNodeVO);
        return result;
    }

    private List<DeptRespNodeVO> getTree(List<SysDept> all) {
        return all.stream().map(s -> {
            if (s.getPid().equals("0")) {
                DeptRespNodeVO respNodeVO = new DeptRespNodeVO();
                respNodeVO.setId(s.getId());
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChild(s.getId(), all));
                return respNodeVO;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private List<DeptRespNodeVO> getChild(String id, List<SysDept> all) {
        return all.stream().map(s -> {
            if (s.getPid().equals(id)) {
                DeptRespNodeVO respNodeVO = new DeptRespNodeVO();
                respNodeVO.setId(s.getId());
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChild(s.getId(), all));
                return respNodeVO;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public SysDept addDept(DeptAddReqVO vo) {
        String relationCode;
        long deptCount = redisService.incrby(Constant.DEPT_CODE_KEY, 1);
        String deptCode = CodeUtil.deptCode(String.valueOf(deptCount), 7, "0");
        SysDept parent = sysDeptMapper.selectByPrimaryKey(vo.getPid());
        if (vo.getPid().equals("0")) {
            relationCode = deptCode;
        } else if (parent == null) {
            log.info("父级数据不存在{}", vo.getPid());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        } else {
            relationCode = parent.getRelationCode() + deptCode;
        }
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(vo, sysDept);
        sysDept.setId(UUID.randomUUID().toString());
        sysDept.setCreateTime(new Date());
        sysDept.setDeptNo(deptCode);
        sysDept.setRelationCode(relationCode);
        int i = sysDeptMapper.insertSelective(sysDept);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        return sysDept;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDept(DeptUpdateReqVO vo) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(vo.getId());
        if (null == sysDept) {
            log.error("传入的 id: {}，不合法", vo.getId());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        //保存更新部门数据
        SysDept update = new SysDept();
        BeanUtils.copyProperties(vo, update);
        update.setUpdateTime(new Date());
        int i = sysDeptMapper.updateByPrimaryKeySelective(update);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //维护层级关系
        if (!vo.getPid().equals(sysDept.getPid())) {
            //子集的部门层级关系编码=父级部门编码+它本身的部门编码
            SysDept newParent = sysDeptMapper.selectByPrimaryKey(vo.getPid());
            if (!vo.getPid().equals("0") && newParent == null) {
                log.info("修改后的上级部门在数据库中不存在：{}", vo.getPid());
                throw new BusinessException(BaseResponseCode.DATA_ERROR);
            }
            SysDept oldParent = sysDeptMapper.selectByPrimaryKey(sysDept.getPid());
            String oldRelation;
            String newRelation;
            //根目录挂靠到其他目录
            if (sysDept.getPid().equals("0")) {
                oldRelation = sysDept.getRelationCode();
                newRelation = newParent.getRelationCode() + sysDept.getDeptNo();
            } else if (vo.getPid().equals("0")) {
                //其他目录升到根目录
                oldRelation = sysDept.getRelationCode();
                newRelation = sysDept.getDeptNo();
            } else {
                //父级部门转移到到其他部门
                oldRelation = oldParent.getRelationCode();
                newRelation = newParent.getRelationCode();
            }
            sysDeptMapper.updateRelationCode(oldRelation, newRelation, sysDept.getRelationCode());
        }
    }

    @Override
    public void deletedDept(String id) {
        //查找它和它的叶子节点
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(id);
        if (sysDept == null) {
            log.info("传入的部门 id 在数据库中不存在：{}", id);
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        List<String> list = sysDeptMapper.selectChildIds(sysDept.getRelationCode());
        //判断它和它子集的叶子节点是否关联有用户
        List<SysUser> sysUsers = userService.selectUserInfoByDeptIds(list);
        if (!sysUsers.isEmpty()) {
            throw new BusinessException(BaseResponseCode.NOT_PERMISSION_DELETED_DEPT);
        }
        //逻辑删除部门数据
        int i = sysDeptMapper.deletedDepts(new Date(), list);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }
}
