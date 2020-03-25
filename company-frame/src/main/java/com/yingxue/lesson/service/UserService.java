package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;

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
     * @param vo
     * @return
     */
    LoginRespVO login(LoginReqVO vo);

    /**
     * 登出接口
     * @param accessToken
     * @param refreshToken
     */
    void logout(String accessToken,String refreshToken);
}
