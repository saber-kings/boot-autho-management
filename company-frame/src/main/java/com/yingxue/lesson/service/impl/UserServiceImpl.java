package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.utils.PasswordUtils;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.req.UserPageReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageReqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Saber污妖王
 * TODO: 用户业务层实现类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RedisService redisService;

    @Override
    public LoginRespVO login(LoginReqVO vo) {
        //通过用户名查询用户信息
        //如果查询存在用户
        //就比较它密码是否一样
        SysUser userInfoByName = sysUserMapper.getUserInfoByName(vo.getUsername());
        if (userInfoByName == null) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
        }
        if (userInfoByName.getStatus() == 2) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK);
        }
        if (!PasswordUtils.matches(userInfoByName.getSalt(), vo.getPassword(), userInfoByName.getPassword())) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_PASSWORD_ERROR);
        }
        LoginRespVO loginRespVO = new LoginRespVO();
        loginRespVO.setPhone(userInfoByName.getPhone());
        loginRespVO.setUsername(userInfoByName.getUsername());
        loginRespVO.setId(userInfoByName.getId());
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constant.JWT_ROLES_KEY, getRolesByUserId(userInfoByName.getId()));
        claims.put(Constant.JWT_PERMISSIONS_KEY, getPermissionsByUserId(userInfoByName.getId()));
        claims.put(Constant.JWT_USER_NAME, userInfoByName.getUsername());
        String accessToken = JwtTokenUtil.getAccessToken(userInfoByName.getId(), claims);
        String refreshToken;
        if (vo.getType().equals("1")) {
            refreshToken = JwtTokenUtil.getRefreshToken(userInfoByName.getId(), claims);
        } else {
            refreshToken = JwtTokenUtil.getRefreshAppToken(userInfoByName.getId(), claims);
        }
        loginRespVO.setAccessToken(accessToken);
        loginRespVO.setRefreshToken(refreshToken);
        return loginRespVO;
    }

    @Override
    public void logout(String accessToken, String refreshToken) {
        if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(refreshToken)) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        log.info("subject.getPrincipals()={}", subject.getPrincipals());
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        String userId = JwtTokenUtil.getUserId(accessToken);
        /**
         * 把token 加入黑名单 禁止再登录
         */
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        /**
         * 把 refreshToken 加入黑名单 禁止再拿来刷新token
         */
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken, userId, JwtTokenUtil.getRemainingTime(refreshToken), TimeUnit.MILLISECONDS);
    }

    @Override
    public PageReqVO<SysUser> pageInfo(UserPageReqVO vo) {
        //Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.selectAll(vo);
        return PageUtil.getPageVO(sysUsers);
    }

    /**
     * mock 数据
     * 获取用户的角色
     * 这里先用伪代码代替
     * 后面权限管理系统再从 DB 读取
     *
     * @param userId 用户编号
     * @return java.util.List<String>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    private List<String> getRolesByUserId(String userId) {
        List<String> list = new ArrayList<>();
        if ("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)) {
            list.add("admin");
        } else {
            list.add("test");
        }
        return list;
    }

    /**
     * mock 数据
     * 获取用户的权限
     * 这里先用伪代码代替
     * 后面权限管理系统再从 DB 读取
     *
     * @param userId 用户编号
     * @return java.util.List<String>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    private List<String> getPermissionsByUserId(String userId) {
        List<String> list = new ArrayList<>();
        if ("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)) {
            list.add("sys:user:add");
            list.add("sys:user:list");
            list.add("sys:user:update");
            list.add("sys:user:detail");
        } else {
            list.add("sys:user:detail");
        }
        return list;
    }
}
