package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.vo.req.PermissionPageReqVO;

import java.util.List;

/**
 * 菜单权限相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysPermissionMapper {
    /**
     * 根据ID删除菜单权限
     *
     * @param id 菜单权限ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);
    
    /**
     * 插入菜单权限，这里是插入所有字段
     *
     * @param record 菜单权限实体
     * @return 插入的菜单权限
     */
    int insert(SysPermission record);

    /**
     * 插入菜单权限，这里是插入所有不为空的字段
     *
     * @param record 菜单权限实体
     * @return 插入的菜单权限
     */
    int insertSelective(SysPermission record);

    /**
     * 根据ID查询菜单权限
     *
     * @param id 菜单权限ID
     * @return 查询到的菜单权限
     */
    SysPermission selectByPrimaryKey(String id);

    /**
     * 根据菜单权限ID更改对应菜单权限，这里是更改不为空的字段
     *
     * @param record 菜单权限实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * 根据菜单权限ID更改对应菜单权限，这里是更改所有字段
     *
     * @param record 菜单权限实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysPermission record);

    /**
     * 查询所有菜单权限
     *
     * @return 菜单权限集合
     */
    List<SysPermission> selectAll();

    /**
     * 分页查询菜单权限
     *
     * @param vo 分页查询参数封装VO
     * @return 菜单权限集合
     */
    List<SysPermission> pageInfo(PermissionPageReqVO vo);

    /**
     * 根据菜单权限ID其子节点
     * @param permissionId 菜单权限ID
     * @return 子节点集合
     */
    List<SysPermission> selectChild(String permissionId);

    /**
     * 根据ID查询菜单权限信息
     * @param ids ID集合
     * @return 菜单权限信息集合
     */
    List<SysPermission> selectInfoByIds(List<String> ids);
}