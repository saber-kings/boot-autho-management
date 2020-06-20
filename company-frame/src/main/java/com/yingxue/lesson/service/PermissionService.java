package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.req.PermissionPageReqVO;
import com.yingxue.lesson.vo.req.PermissionUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 权限相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/31
 * @package com.yingxue.lesson.service
 */
public interface PermissionService {
    /**
     * 查询所有菜单权限
     *
     * @return 菜单权限集合
     */
    List<SysPermission> selectAll();

    /**
     * 菜单权限数据分页的接口
     *
     * @param vo 菜单权限分页数据的VO
     * @return 返回分页数据封装类
     */
    PageRespVO<SysPermission> pageInfo(PermissionPageReqVO vo);

    /**
     * 查询所有菜单权限树，只遍历到菜单
     *
     * @return 菜单权限树数据VO集合
     */
    List<PermissionRespNodeVO> selectAllMenuByTree();

    /**
     * 新增菜单权限
     *
     * @param vo 新增菜单权限请求的数据VO
     * @return 新增的菜单权限信息
     */
    SysPermission addPermission(PermissionAddReqVO vo);

    /**
     * 根据用户ID查询菜单权限树
     *
     * @param userId 用户ID
     * @return 菜单权限树数据VO集合
     */
    List<PermissionRespNodeVO> permissionTreeList(String userId);

    /**
     * 查询所有菜单权限树（深度遍历，遍历到按钮层级）
     *
     * @return 菜单权限树数据VO集合
     */
    List<PermissionRespNodeVO> selectAllTree();

    /**
     * 修改菜单权限
     *
     * @param vo 修改菜单权限请求的数据VO
     */
    void updatePermission(PermissionUpdateReqVO vo);

    /**
     * 删除菜单权限
     *
     * @param permissionId 菜单权限ID
     */
    void deletedPermission(String permissionId);

    /**
     * 根据用户ID查询其所拥有的所有权限的授权标识，
     * 用于权限控制
     *
     * @param userId 用户ID
     * @return 权限授权标识集合
     */
    List<String> getPermissionByUserId(String userId);

    /**
     * 根据用户ID查询其所拥有的所有权限信息
     *
     * @param userId 用户ID
     * @return 权限集合
     */
    List<SysPermission> getPermissionsById(String userId);
}
