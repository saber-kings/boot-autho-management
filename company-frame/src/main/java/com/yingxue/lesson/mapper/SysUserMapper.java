package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.UserPageReqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysUserMapper {
    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入用户，这里是插入所有字段
     *
     * @param record 用户实体
     * @return 插入的用户
     */
    int insert(SysUser record);

    /**
     * 插入用户，这里是插入所有不为空的字段
     *
     * @param record 用户实体
     * @return 插入的用户
     */
    int insertSelective(SysUser record);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 查询到的用户
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * 根据用户ID更改对应用户，这里是更改不为空的字段
     *
     * @param record 用户实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据用户ID更改对应用户，这里是更改所有字段
     *
     * @param record 用户实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getUserInfoByName(String username);

    /**
     * 分页查询用户
     *
     * @param vo 分页查询参数封装VO
     * @return 用户集合
     */
    List<SysUser> selectAll(UserPageReqVO vo);

    /**
     * 批量/删除用户
     *
     * @param sysUser 操作删除的用户信息
     * @param list    ID集合
     * @return 删除的行数
     */
    int deletedUsers(@Param("sysUser") SysUser sysUser, @Param("list") List<String> list);

    /**
     * 根据部门ID集合查找用户
     *
     * @param deptIds 部门ID集合
     * @return 用户集合
     */
    List<SysUser> selectUserInfoByDeptIds(List<String> deptIds);
}