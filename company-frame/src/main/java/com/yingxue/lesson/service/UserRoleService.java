package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.UserOwnRoleReqVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 用户角色关联相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/29
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface UserRoleService {
    List<String> getRoleIdsByUserId(String userId);

    void addUserRoleInfo(UserOwnRoleReqVO vo);

    List<String> getUserIdsByRoleIds(List<String> roleIds);

    List<String> getUserIdsByRoleId(String roleId);

    int removeByRoleId(String roleId);
}
