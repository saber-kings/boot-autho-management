package com.yingxue.lesson.service.impl;

import java.util.*;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysDeptMapper;
import com.yingxue.lesson.mapper.SysUserMapper;
import com.yingxue.lesson.service.*;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.utils.PasswordUtils;
import com.yingxue.lesson.utils.TokenSettings;
import com.yingxue.lesson.vo.req.*;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.UserOwnRoleRespVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;

    @Resource
    private TokenSettings tokenSettings;

    @Resource
    private PermissionService permissionService;

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
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK_TIP);
        }
        if (PasswordUtils.misMatch(userInfoByName.getSalt(), vo.getPassword(), userInfoByName.getPassword())) {
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
        // 把 access_token 加入黑名单 禁止再拿来访问我们的系统资源
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        // 把 refresh_token 加入黑名单 禁止再拿来刷新token
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken, userId, JwtTokenUtil.getRemainingTime(refreshToken), TimeUnit.MILLISECONDS);
    }

    @Override
    public PageRespVO<SysUser> pageInfo(UserPageReqVO vo) {
        //Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.selectAll(vo);
        sysUsers.forEach(s -> {
            SysDept sysDept = sysDeptMapper.selectByPrimaryKey(s.getDeptId());
            if (sysDept != null) {
                s.setDeptName(sysDept.getName());
            }
        });
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
//        List<String> list = new ArrayList<>();
//        if ("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)) {
//            list.add("admin");
//        } else {
//            list.add("test");
//        }
        return roleService.getNamesByIds(userId);
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
//        List<String> list = new ArrayList<>();
//        if ("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)) {
//            list.add("sys:user:add");
//            list.add("sys:user:list");
//            list.add("sys:user:update");
//            list.add("sys:user:detail");
//        } else {
//            list.add("sys:user:detail");
//        }
        return permissionService.getPermissionByUserId(userId);
    }

    @Override
    public void addUser(UserAddReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setId(UUID.randomUUID().toString());
        sysUser.setCreateTime(new Date());
        String salt = PasswordUtils.getSalt();
        String ecdPwd = PasswordUtils.encode(vo.getPassword(), salt);
        sysUser.setSalt(salt);
        sysUser.setPassword(ecdPwd);
        int i = sysUserMapper.insertSelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public UserOwnRoleRespVO getUserOwnRole(String userId) {
        UserOwnRoleRespVO respVO = new UserOwnRoleRespVO();
        respVO.setOwnRoles(userRoleService.getRoleIdsByUserId(userId));
        respVO.setAllRole(roleService.selectAll());
        return respVO;
    }

    @Override
    public void setUserOwnRole(UserOwnRoleReqVO vo) {
        userRoleService.addUserRoleInfo(vo);
        // 标记用户 要主动去刷新
        redisService.set(Constant.JWT_REFRESH_KEY + vo.getUserId(),
                vo.getUserId(), tokenSettings.getAccessTokenExpireTime().toMillis(),
                TimeUnit.MILLISECONDS);
        //删除用户缓存的授权信息
        redisService.delete(Constant.IDENTIFY_CACHE_KEY + vo.getUserId());
    }

    @Override
    public String refreshToken(String refreshToken) {
        //校验刷新 token 是否有效
        //校验刷新 token 是否被加入黑名单
        if (!JwtTokenUtil.validateToken(refreshToken) || redisService.hasKey(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        String userId = JwtTokenUtil.getUserId(refreshToken);
        String userName = JwtTokenUtil.getUserName(refreshToken);
        HashMap<String, Object> cliams = new HashMap<>();
        cliams.put(Constant.JWT_USER_NAME, userName);
        cliams.put(Constant.JWT_ROLES_KEY, getRolesByUserId(userId));
        cliams.put(Constant.JWT_PERMISSIONS_KEY, getPermissionsByUserId(userId));
        return JwtTokenUtil.getAccessToken(userId, cliams);
    }

    @Override
    public void updateUserInfo(UserUpdateReqVO vo, String operationId) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateId(operationId);
        if (StringUtils.isEmpty(vo.getPassword())) {
            sysUser.setPassword(null);
        } else {
            String salt = PasswordUtils.getSalt();
            String ecdPwd = PasswordUtils.encode(vo.getPassword(), salt);
            sysUser.setSalt(salt);
            sysUser.setPassword(ecdPwd);
        }

        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        if (vo.getStatus() == 2) {
            redisService.set(Constant.ACCOUNT_LOCK_KEY + vo.getId(), vo.getId());
        } else {
            redisService.delete(Constant.ACCOUNT_LOCK_KEY + vo.getId());
        }
    }

    @Override
    public void deletedUsers(List<String> list, String operationId) {
        SysUser sysUser = new SysUser();
        sysUser.setUpdateId(operationId);
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.deletedUsers(sysUser, list);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        list.forEach(userId -> {
            redisService.set(Constant.DELETED_USER_KEY + userId,
                    userId,
                    tokenSettings.getRefreshTokenExpireAppTime().toMillis(),
                    TimeUnit.MILLISECONDS);
            //删除用户缓存的授权信息
            redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
        });
    }

    @Override
    public List<SysUser> selectUserInfoByDeptIds(List<String> deptIds) {
        return sysUserMapper.selectUserInfoByDeptIds(deptIds);
    }

    @Override
    public SysUser detailInfo(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void userUpdateDetailInfo(UserUpdateDetailInfoReqVO vo, String userId) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setId(userId);
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateId(userId);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        //校验旧密码
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if (sysUser == null) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        if (PasswordUtils.misMatch(sysUser.getSalt(), vo.getOldPwd(), sysUser.getPassword())) {
            throw new BusinessException(BaseResponseCode.OLD_PASSWORD_ERROR);
        }
        //保存新密码
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateId(userId);
        sysUser.setPassword(PasswordUtils.encode(vo.getNewPwd(), sysUser.getSalt()));
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }

        // 把 access_token 加入黑名单 禁止再拿来访问我们的系统资源
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        // 把 refresh_token 加入黑名单 禁止再拿来刷新token
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken, userId, JwtTokenUtil.getRemainingTime(refreshToken), TimeUnit.MILLISECONDS);
        //删除用户缓存的授权信息
        redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
    }
}
