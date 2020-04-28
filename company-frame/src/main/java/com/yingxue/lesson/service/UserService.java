package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.AddUserReqVO;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.req.UserPageReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;

/**
 * @Author: Saber污妖王
 * TODO: 用户业务层接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface UserService {
    /**
     * 登录接口
     * @param vo 接收登陆请求数据的 vo
     * @return
     */
    LoginRespVO login(LoginReqVO vo);

    /**
     * 登出接口
     * @param accessToken 业务 token
     * @param refreshToken 刷新 token
     */
    void logout(String accessToken,String refreshToken);

    /**
     * 用户数据分页的接口
     * @param vo 用户分页数据的 vo
     * @return 返回分页数据封装类
     */
    PageRespVO<SysUser> pageInfo(UserPageReqVO vo);

    void addUser(AddUserReqVO vo);
}
