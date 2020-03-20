package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.service.utils.PasswordUtils;
import com.yingxue.lesson.vo.req.RegisterReqVO;
import com.yingxue.lesson.vo.req.UpdateUserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

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

    @Override
    public String register(RegisterReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setCreateTime(new Date());
        sysUser.setId(UUID.randomUUID().toString());
        String salt = PasswordUtils.getSalt();
        String encode = PasswordUtils.encode(vo.getPassword(), salt);
        sysUser.setPassword(encode);
        sysUser.setSalt(salt);
        sysUser.setDeleted(0);
        int i = sysUserMapper.insert(sysUser);
        if (i != 1) {
            return "注册失败";
        }
        return "注册成功";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateUserInfo(UpdateUserReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        if (StringUtils.isEmpty(sysUser.getPassword())) {
            sysUser.setPassword(null);
        } else {
            String salt = PasswordUtils.getSalt();
            String encode = PasswordUtils.encode(sysUser.getPassword(), salt);
            sysUser.setSalt(salt);
            sysUser.setPassword(encode);
        }
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            return "更改失败";
        }
//        int j = 1/0;
        return "更改成功";
    }

    @Override
    public String deletedUserInfo(String id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setUpdateTime(new Date());
        sysUser.setDeleted(1);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            return "删除失败";
        }
        return "删除成功";
    }
}
