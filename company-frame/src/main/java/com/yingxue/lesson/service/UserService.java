package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.*;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.UserOwnRoleRespVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 用户相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface UserService {
    /**
     * 登录接口
     *
     * @param vo 接收登陆请求数据的 vo
     * @return
     */
    LoginRespVO login(LoginReqVO vo);

    /**
     * 登出接口
     *
     * @param accessToken  业务 token
     * @param refreshToken 刷新 token
     */
    void logout(String accessToken, String refreshToken);

    /**
     * 用户数据分页的接口
     *
     * @param vo 用户分页数据的 vo
     * @return 返回分页数据封装类
     */
    PageRespVO<SysUser> pageInfo(UserPageReqVO vo);

    void addUser(UserAddReqVO vo);

    UserOwnRoleRespVO getUserOwnRole(String userId);

    void setUserOwnRole(UserOwnRoleReqVO vo);

    /**
     * 刷新业务 token 的方法
     *
     * @param refreshToken 刷新 token
     * @return
     */
    String refreshToken(String refreshToken);

    void updateUserInfo(UserUpdateReqVO vo, String operationId);

    void deletedUsers(List<String> list, String operationId);

    List<SysUser> selectUserInfoByDeptIds(List<String> deptIds);

    SysUser detailInfo(String userId);

    //更新个人用户信息接口
    void userUpdateDetailInfo(UserUpdateDetailInfoReqVO vo, String userId);

    void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken);
}
