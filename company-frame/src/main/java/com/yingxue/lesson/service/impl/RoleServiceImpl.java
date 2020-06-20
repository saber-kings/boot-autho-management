package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysRoleMapper;
import com.yingxue.lesson.service.*;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.utils.TokenSettings;
import com.yingxue.lesson.vo.req.RoleAddReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;
import com.yingxue.lesson.vo.req.RoleUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Saber污妖王
 * TODO: 角色业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.service.impl
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RedisService redisService;

    @Resource
    private TokenSettings tokenSettings;

    @Override
    public PageRespVO<SysRole> pageInfo(RolePageReqVO vo) {
        PageHelper.offsetPage(vo.getPageNum(), vo.getPageSize());
        List<SysRole> sysRoles = sysRoleMapper.selectAll(vo);
        return PageUtil.getPageVO(sysRoles);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole addRole(RoleAddReqVO vo) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(vo, sysRole);
        sysRole.setId(UUID.randomUUID().toString());
        sysRole.setCreateTime(new Date());
        int i = sysRoleMapper.insertSelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (vo.getPermissions() != null && !vo.getPermissions().isEmpty()) {
            RolePermissionOperationReqVO operationReqVO = new RolePermissionOperationReqVO();
            operationReqVO.setRoleId(sysRole.getId());
            operationReqVO.setPermissionIds(vo.getPermissions());
            rolePermissionService.addRolePermission(operationReqVO);
        }
        return sysRole;
    }

    @Override
    public List<SysRole> selectAll() {
        return sysRoleMapper.selectAll(new RolePageReqVO());
    }

    @Override
    public SysRole detailInfo(String id) {
        //通过 id 获取角色详细信息
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        if (sysRole == null) {
            log.error("传入的 id: {}，不合法", id);
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        //获取所有菜单权限树
        List<PermissionRespNodeVO> tree = permissionService.selectAllTree();
        //获取该角色拥有的菜单权限
        List<String> permissionIds = rolePermissionService.getPermissionIdsByRoleId(id);
        Set<String> checkList = new HashSet<>(permissionIds);
        //遍历菜单权限树的数据
        setChecked(tree, checkList);
        sysRole.setPermissionTree(tree);
        return sysRole;
    }

    /**
     * 遍历原先拥有的菜单权限设置菜单权限树的选中状态
     * 子集选中从它往上到跟目录都被选中，
     * 父级选中从它到它所有的叶子节点都会被选中
     * 这样我们就直接遍历最底层及就可以了
     *
     * @param list      所有的菜单权限树
     * @param checkList 原先拥有的菜单权限
     */
    private void setChecked(List<PermissionRespNodeVO> list, Set<String> checkList) {
        list.forEach(node -> {
            if (checkList.contains(node.getId()) &&
                    (node.getChildren() == null || node.getChildren().isEmpty())) {
                node.setChecked(true);
            }
            setChecked(node.getChildren(), checkList);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRole(RoleUpdateReqVO vo) {
        //判断传入角色 id 是否存在
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(vo.getId());
        if (null == sysRole) {
            log.error("传入的 id: {}，不合法", vo.getId());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        //保存角色信息
        BeanUtils.copyProperties(vo, sysRole);
        sysRole.setUpdateTime(new Date());
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //修改该角色和菜单权限的关联数据
        RolePermissionOperationReqVO reqVO = new RolePermissionOperationReqVO();
        reqVO.setRoleId(vo.getId());
        reqVO.setPermissionIds(vo.getPermissions());
        rolePermissionService.addRolePermission(reqVO);
        /*
         * 修改了角色关联的菜单权限后 要主动去刷新 token
         * 因为用户所拥有的菜单权限是通过角色去关联的
         * 所以跟这个角色关联的用户都要重新刷新token
         */
        markUser(vo.getId());
    }

    /**
     * 标记传入角色关联的用户，使得在用户认证的时候去主动刷新
     *
     * @param id 传入角色的 id
     */
    private void markUser(String id) {
        //查询和该角色关联的用户
        List<String> userIds = userRoleService.getUserIdsByRoleId(id);
        if (!userIds.isEmpty()) {
            //标记用户，使得在用户认证的时候判断其是否主动刷新过
            userIds.forEach(uid -> {
                redisService.set(Constant.JWT_REFRESH_KEY
                                + uid, uid,
                        tokenSettings.getAccessTokenExpireTime().toMillis(),
                        TimeUnit.MILLISECONDS);
                //删除用户缓存的授权信息
                redisService.delete(Constant.IDENTIFY_CACHE_KEY + uid);
            });
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletedRole(String id) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setDeleted(0);
        sysRole.setUpdateTime(new Date());
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //删除角色和菜单权限关联数据
        rolePermissionService.removeByRoleId(id);
        //删除角色和用户关联数据
        userRoleService.removeByRoleId(id);
        markUser(id);
    }

    @Override
    public List<String> getNamesByIds(String userId) {
        List<String> roleIds = userRoleService.getRoleIdsByUserId(userId);
        if (roleIds.isEmpty()) {
            return null;
        }
        return sysRoleMapper.selectNamesByIds(roleIds);
    }
}
