package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.*;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.UserOwnRoleRespVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 用户相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.service
 */
public interface UserService {
    /**
     * 登录接口
     *
     * @param vo 接收登陆请求的数据VO
     * @return 响应登陆数据的VO
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
     * @param vo 用户分页数据的VO
     * @return 返回分页数据封装类
     */
    PageRespVO<SysUser> pageInfo(UserPageReqVO vo);

    /**
     * 新增用户
     *
     * @param vo 新增用户请求的数据VO
     */
    void addUser(UserAddReqVO vo);

    /**
     * 根据ID查询用户拥有的角色
     *
     * @param userId 用户ID
     * @return 用户拥有的角色信息
     */
    UserOwnRoleRespVO getUserOwnRole(String userId);

    /**
     * 赋予用户角色
     *
     * @param vo 赋予用户角色请求的数据VO
     */
    void setUserOwnRole(UserOwnRoleReqVO vo);

    /**
     * 刷新业务 token 的方法
     *
     * @param refreshToken 刷新 token
     * @return 业务 token
     */
    String refreshToken(String refreshToken);

    /**
     * 修改用户信息
     *
     * @param vo          修改用户信息请求的数据VO
     * @param operationId 操作员ID
     */
    void updateUserInfo(UserUpdateReqVO vo, String operationId);

    /**
     * 根据ID(批量)删除用户
     *
     * @param list        ID集合
     * @param operationId 操作员ID
     */
    void deletedUsers(List<String> list, String operationId);

    /**
     * 根据部门ID查询用户
     *
     * @param deptIds 部门ID集合
     * @return 用户集合
     */
    List<SysUser> selectUserInfoByDeptIds(List<String> deptIds);

    /**
     * 根据ID查询用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    SysUser detailInfo(String userId);

    /**
     * 个人用户修改资料接口
     *
     * @param vo     用户修改信息请求的数据VO
     * @param userId 用户ID
     */
    void userUpdateDetailInfo(UserUpdateDetailInfoReqVO vo, String userId);

    /**
     * 修改密码
     * 注：两个 token 用于将用户登出时旧的 token 加入黑名单，
     * 即重置登陆状态
     *
     * @param vo           用户修改密码请求的数据VO
     * @param accessToken  业务 token
     * @param refreshToken 刷新 token
     */
    void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken);

    /**
     * 查询用户表字段列表
     *
     * @return 字段列表
     */
    List<SysData> getItems();
}
