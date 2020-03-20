package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.service.impl
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser getUserInfo(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
