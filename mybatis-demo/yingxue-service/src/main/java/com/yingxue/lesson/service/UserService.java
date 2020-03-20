package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.RegisterReqVO;
import com.yingxue.lesson.vo.req.UpdateUserReqVO;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.service
 * @version:1.0
 */
public interface UserService {
    SysUser getUserInfo(String id);

    String register(RegisterReqVO vo);

    String updateUserInfo(UpdateUserReqVO vo);

    String deletedUserInfo(String id);
}
