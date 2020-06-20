package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.UserOwnRoleReqVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 用户角色关联相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/29
 * @package com.yingxue.lesson.service
 */
public interface UserRoleService {
    /**
     * 根据用户ID查询角色ID集合
     *
     * @param userId 用户ID
     * @return 角色ID集合
     */
    List<String> getRoleIdsByUserId(String userId);

    /**
     * 向用户赋予角色
     *
     * @param vo 用户赋予角色请求的数据VO
     */
    void addUserRoleInfo(UserOwnRoleReqVO vo);

    /**
     * 根据角色ID集合查询用户ID集合
     *
     * @param roleIds 角色ID集合
     * @return 用户ID集合
     */
    List<String> getUserIdsByRoleIds(List<String> roleIds);

    /**
     * 根据角色ID查询用户ID集合
     *
     * @param roleId 角色ID
     * @return 用户ID集合
     */
    List<String> getUserIdsByRoleId(String roleId);

    /**
     * 根据角色ID删除用户角色关系
     *
     * @param roleId 角色ID
     * @return 删除行数
     */
    int removeByRoleId(String roleId);
}
