package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysDeptMapper;
import com.yingxue.lesson.service.DeptService;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.utils.CodeUtil;
import com.yingxue.lesson.vo.req.AddDeptReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

    @Override
    public List<SysDept> selectAll() {
        List<SysDept> list = sysDeptMapper.selectAll();
        list.forEach(s -> {
            SysDept parent = sysDeptMapper.selectByPrimaryKey(s.getPid());
            if (parent != null) {
                s.setPidName(s.getName());
            }
        });
        return list;
    }

    @Override
    public List<DeptRespNodeVO> deptTreeList() {
        DeptRespNodeVO respNodeVO = new DeptRespNodeVO();
        respNodeVO.setId("0");
        respNodeVO.setTitle("默认顶级部门");
        respNodeVO.setChildren(getTree(sysDeptMapper.selectAll()));
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
    public SysDept addDept(AddDeptReqVO vo) {
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
        if (i!=1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        return sysDept;
    }
}
