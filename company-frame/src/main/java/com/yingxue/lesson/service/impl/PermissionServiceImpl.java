package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysPermissionMapper;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.service.RolePermissionService;
import com.yingxue.lesson.service.UserRoleService;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.utils.TokenSettings;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.req.PermissionPageReqVO;
import com.yingxue.lesson.vo.req.PermissionUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Saber污妖王
 * TODO: 权限业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/31
 * @package com.yingxue.lesson.service.impl
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RedisService redisService;

    @Resource
    private TokenSettings tokenSettings;

    @Override
    public List<SysPermission> selectAll() {
        List<SysPermission> sysPermissions = sysPermissionMapper.selectAll();
        setPidName(sysPermissions);
        return sysPermissions;
    }

    @Override
    public PageRespVO<SysPermission> pageInfo(PermissionPageReqVO vo) {
        //Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysPermission> sysPermissions = sysPermissionMapper.pageInfo(vo);
        setPidName(sysPermissions);
        return PageUtil.getPageVO(sysPermissions);
    }

    private void setPidName(List<SysPermission> sysPermissions) {
        if (!sysPermissions.isEmpty()) {
            sysPermissions.forEach(s -> {
                SysPermission parent = sysPermissionMapper.selectByPrimaryKey(s.getPid());
                if (parent != null) {
                    s.setPidName(parent.getName());
                }
            });
        }
    }

    @Override
    public List<PermissionRespNodeVO> selectAllMenuByTree() {
        List<SysPermission> list = sysPermissionMapper.selectAll();
        List<PermissionRespNodeVO> result = new ArrayList<>();
        PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
        respNodeVO.setId("0");
        respNodeVO.setTitle("默认顶级菜单");
        respNodeVO.setChildren(getTree(list, true));
        result.add(respNodeVO);
        return result;
    }

    /**
     * 递归获取菜单树
     * type=true 递归遍历到菜单
     * type=false 递归遍历到按钮
     *
     * @param all  菜单权限集合
     * @param type 是否只遍历到菜单
     * @return java.util.List<com.yingxue.lesson.vo.resp.PermissionRespNodeVO>
     */
    private List<PermissionRespNodeVO> getTree(List<SysPermission> all, boolean type) {
        if (all == null || all.isEmpty()) {
            return new ArrayList<>();
        }
        return all.stream().map(s -> {
            if ("0".equals(s.getPid())) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                if (type) {
                    respNodeVO.setChildren(getChildExcBtn(s.getId(), all));
                } else {
                    respNodeVO.setChildren(getChild(s.getId(), all));
                }
                return respNodeVO;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 递归遍历所有数据
     *
     * @param id  要判断是否是父节点的 id
     * @param all 所有节点
     * @return 最终返回传入权限的所有子节点
     */
    private List<PermissionRespNodeVO> getChild(String id, List<SysPermission> all) {
        return all.stream().map(s -> {
            if (s.getPid().equals(id)) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChild(s.getId(), all));
                return respNodeVO;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 只递归获取目录和菜单
     *
     * @param id  父级菜单 id
     * @param all 菜单权限集合
     * @return java.util.List<com.yingxue.lesson.vo.resp.PermissionRespNodeVO>
     */
    private List<PermissionRespNodeVO> getChildExcBtn(String id, List<SysPermission> all) {
        return all.stream().map(s -> {
            if (s.getPid().equals(id) && s.getType() != 3) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChildExcBtn(s.getId(), all));
                return respNodeVO;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public SysPermission addPermission(PermissionAddReqVO vo) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(vo, sysPermission);
        verifyForm(sysPermission);
        sysPermission.setId(UUID.randomUUID().toString());
        sysPermission.setCreateTime(new Date());
        int count = sysPermissionMapper.insertSelective(sysPermission);
        if (count != 1) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        return sysPermission;
    }

    /**
     * 操作后的菜单类型是目录的时候 父级必须为目录
     * 操作后的菜单类型是菜单的时候，父类必须为目录类型
     * 操作后的菜单类型是按钮的时候 父类必须为菜单类型
     *
     * @param sysPermission 提交的菜单权限
     */
    private void verifyForm(SysPermission sysPermission) {
        SysPermission parent = sysPermissionMapper.selectByPrimaryKey(sysPermission.getPid());
        switch (sysPermission.getType()) {
            case 1:
                if (parent != null) {
                    if (parent.getType() != 1) {
                        throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
                    }
                } else if (!"0".equals(sysPermission.getPid())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
                }
                break;
            case 2:
                if (parent == null || parent.getType() != 1) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_MENU_ERROR);
                }
                if (StringUtils.isEmpty(sysPermission.getUrl())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
                }
                break;
            case 3:
                if (parent == null || parent.getType() != 2) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_BTN_ERROR);
                }
                if (StringUtils.isEmpty(sysPermission.getPerms())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_PERMS_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getUrl())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getMethod())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_METHOD_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getCode())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_CODE_NULL);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public List<PermissionRespNodeVO> permissionTreeList(String userId) {
        return getTree(getPermissionsById(userId), true);
    }

    @Override
    public List<PermissionRespNodeVO> selectAllTree() {
        return getTree(selectAll(), false);
    }

    @Override
    public void updatePermission(PermissionUpdateReqVO vo) {
        //校验数据
        SysPermission update = new SysPermission();
        BeanUtils.copyProperties(vo, update);
        verifyForm(update);
        SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(vo.getId());
        if (sysPermission == null) {
            log.info("传入的id在数据库中不存在");
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (!sysPermission.getPid().equals(vo.getPid())) {
            //所属菜单发生了变化要校验该权限是否存在子集
            List<SysPermission> childList = sysPermissionMapper.selectChild(vo.getId());
            if (!childList.isEmpty()) {
                throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_UPDATE);
            }
        }
        update.setUpdateTime(new Date());
        int i = sysPermissionMapper.updateByPrimaryKeySelective(update);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //判断授权标识符是否发生了变化，若发生了变化需要标记该权限关联的用户，让其去主动刷新 token
        if (!sysPermission.getPerms().equals(vo.getPerms())) {
            markUser(vo.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletedPermission(String permissionId) {
        //判断是否有子集关联
        List<SysPermission> childList = sysPermissionMapper.selectChild(permissionId);
        if (!childList.isEmpty()) {
            throw new BusinessException(BaseResponseCode.ROLE_PERMISSION_RELATION);
        }
        //解除相关角色和该菜单权限的关联
        rolePermissionService.removeByPermissionId(permissionId);
        //更新权限数据
        SysPermission sysPermission = new SysPermission();
        sysPermission.setId(permissionId);
        sysPermission.setUpdateTime(new Date());
        sysPermission.setDeleted(0);
        int i = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //标记该权限关联的用户，让其去主动刷新 token
        markUser(permissionId);
    }

    /**
     * 标记传入权限所关联的用户，让其去主动刷新 token
     *
     * @param permissionId 传入权限 ID
     */
    private void markUser(String permissionId) {
        List<String> roleIds = rolePermissionService.getRoleIdsByPermissionId(permissionId);
        if (!roleIds.isEmpty()) {
            List<String> userIds = userRoleService.getUserIdsByRoleIds(roleIds);
            if (!userIds.isEmpty()) {
                userIds.forEach(uid -> {
                    redisService.set(Constant.JWT_REFRESH_KEY + uid, uid,
                            tokenSettings.getAccessTokenExpireTime().toMillis(),
                            TimeUnit.MILLISECONDS);
                    //删除用户缓存的授权信息
                    redisService.delete(Constant.IDENTIFY_CACHE_KEY + uid);
                });
            }
        }
    }

    @Override
    public List<String> getPermissionByUserId(String userId) {
        List<SysPermission> permissions = getPermissionsById(userId);
        if (permissions == null || permissions.isEmpty()) {
            return null;
        }
        return permissions.stream().map(p -> {
            if (!StringUtils.isEmpty(p.getPerms())) {
                return p.getPerms();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public List<SysPermission> getPermissionsById(String userId) {
        List<String> roleIds = userRoleService.getRoleIdsByUserId(userId);
        if (roleIds.isEmpty()) {
            return null;
        }
        List<String> permissionIds = rolePermissionService.getPermissionIdsByRoleIds(roleIds);
        if (permissionIds.isEmpty()) {
            return null;
        }
        return sysPermissionMapper.selectInfoByIds(permissionIds);
    }
}
