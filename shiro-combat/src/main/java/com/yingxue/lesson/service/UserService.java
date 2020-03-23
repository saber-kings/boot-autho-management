package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/23
 * @Description: 描述信息
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface UserService {
    LoginRespVO login(LoginReqVO vo);

    SysUser detail(String id);
}
