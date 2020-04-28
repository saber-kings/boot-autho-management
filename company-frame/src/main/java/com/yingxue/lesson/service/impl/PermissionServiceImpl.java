package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysPermissionMapper;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/31
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> selectAll() {
        List<SysPermission> sysPermissions = sysPermissionMapper.selectAll();
        if (!sysPermissions.isEmpty()) {
//            for (SysPermission sysPermission : sysPermissions) {
//                SysPermission parent = sysPermissionMapper.selectByPrimaryKey(sysPermission.getPid());
//                if (parent != null) {
//                    sysPermission.setPidName(parent.getName());
//                }
//            }
            sysPermissions.forEach(s -> {
                SysPermission parent = sysPermissionMapper.selectByPrimaryKey(s.getPid());
                if (parent != null) {
                    s.setPidName(parent.getName());
                }
            });
        }
        return sysPermissions;
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
//        List<PermissionRespNodeVO> list = new ArrayList<>();
        if (all == null || all.isEmpty()) {
            return new ArrayList<>();
        }
//        for (SysPermission sysPermission : all) {
//            if (sysPermission.getPid().equals("0")) {
//                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
//                BeanUtils.copyProperties(sysPermission, respNodeVO);
//                respNodeVO.setTitle(sysPermission.getName());
//                if (type) {
//                    respNodeVO.setChildren(getChildExcBtn(sysPermission.getId(), all));
//                } else {
//                    respNodeVO.setChildren(getChild(sysPermission.getId(), all));
//                }
//                list.add(respNodeVO);
//            }
//        }
//        return list;
        return all.stream().map(s -> {
            if (s.getPid().equals("0")) {
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
     * @param id
     * @param all
     * @return
     */
    private List<PermissionRespNodeVO> getChild(String id, List<SysPermission> all) {
//        List<PermissionRespNodeVO> list = new ArrayList<>();
//        for (SysPermission s : all) {
//            if (s.getPid().equals(id)) {
//                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
//                BeanUtils.copyProperties(s, respNodeVO);
//                respNodeVO.setTitle(s.getName());
//                respNodeVO.setChildren(getChildExcBtn(s.getId(), all));
//                list.add(respNodeVO);
//            }
//        }
//        return list;
        return all.stream().map(s -> {
            if (s.getPid().equals(id)) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChildExcBtn(s.getId(), all));
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
//        List<PermissionRespNodeVO> list = new ArrayList<>();
//        for (SysPermission s : all) {
//            if (s.getPid().equals(id) && s.getType() != 3) {
//                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
//                BeanUtils.copyProperties(s, respNodeVO);
//                respNodeVO.setTitle(s.getName());
//                respNodeVO.setChildren(getChildExcBtn(s.getId(), all));
//                list.add(respNodeVO);
//            }
//        }
//        return list;
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
                } else if (!sysPermission.getPid().equals("0")) {
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
        }
    }

    @Override
    public List<PermissionRespNodeVO> permissionTreeList(String userId) {
        return getTree(selectAll(), true);
    }

    @Override
    public List<PermissionRespNodeVO> selectAllTree() {
        return getTree(selectAll(), false);
    }
}
