package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.req.RegisterReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/21
 * @Description:com.yingxue.lesson.service
 * @version:1.0
 */
public interface UserService {
    LoginRespVO login(LoginReqVO vo);

    SysUser getUserInfo(String id);

    String register(RegisterReqVO vo);

    String getCode(String phone);
}
