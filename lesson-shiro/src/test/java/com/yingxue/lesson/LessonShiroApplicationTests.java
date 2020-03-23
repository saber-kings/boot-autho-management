package com.yingxue.lesson;

import com.alibaba.druid.pool.DruidDataSource;
import com.yingxue.lesson.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LessonShiroApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void authentication() {
        //构建一个安全管理器（SecurityManager）环境
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //创建一个SimpleAccountRealm 域
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        //添加一个测试账号(后面可以做成读取动态读取数据库)
        simpleAccountRealm.addAccount("zhangsan", "666666");
        //设置Realm
        defaultWebSecurityManager.setRealm(simpleAccountRealm);
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码(用户输入的用户名密码)生成token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan1", "666666");

        try {
            //进行登入(提交认证)
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            //登出logout
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        }

    }

    @Test
    void authorization() {
        //构建一个安全管理器（SecurityManager）环境
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //创建一个SimpleAccountRealm 域
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        //添加一个测试账号(后面可以做成读取动态读取数据库)
        simpleAccountRealm.addAccount("zhangsan", "666666", "admin", "test");
        //设置Realm
        defaultWebSecurityManager.setRealm(simpleAccountRealm);
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);

        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码(用户输入的用户名密码)生成token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan", "666666");

        try {
            //进行登入(提交认证)
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("admin", "test");
            //登出logout
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }

    }

    @Test
    void testIniRealm() {
        //构建一个安全管理器（SecurityManager）环境
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //读取*.ini配置文件，加载用户、角色、权限等信息
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        //设置Realm
        defaultWebSecurityManager.setRealm(iniRealm);
        //将安全管理器配置到工具类里面
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码(用户输入的用户名密码)生成token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123456");

        try {
            //进行登入(提交认证)
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("admin");
            subject.checkPermissions("user:deleted", "user:list");
            //登出logout
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }

    }

    @Test
    void testJdbcRealm(){
        //构建一个安全管理器（SecurityManager）环境
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //构建JDBC域
        JdbcRealm jdbcRealm = new JdbcRealm();
        //构建数据源
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/shiro?serverTimezone=GMT%2B8&useSSL=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("admin123");
        //设置数据源
        jdbcRealm.setDataSource(druidDataSource);
        //开启权限校验
        jdbcRealm.setPermissionsLookupEnabled(true);

        //动态设置自己的SQL
        String authenticationQuery = "select password from sys_users where username = ?";
        String userRolesQuery = "select role_name from sys_user_roles where username = ?";
        String permissionsQuery = "select permission from sys_roles_permissions where role_name = ?";

        jdbcRealm.setAuthenticationQuery(authenticationQuery);
        jdbcRealm.setUserRolesQuery(userRolesQuery);
        jdbcRealm.setPermissionsQuery(permissionsQuery);

        //设置Realm
        defaultWebSecurityManager.setRealm(jdbcRealm);
        //将安全管理器配置到工具类里面
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码(用户输入的用户名密码)生成token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("test", "123456");

        try {
            //进行登入(提交认证)
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("test");
            subject.checkPermissions("user:deleted", "user:list");
            //登出logout
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }
    }

    @Test
    void testCustomRealm(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        CustomRealm customRealm = new CustomRealm();
        defaultWebSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123456");

        try {
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("test");
            subject.checkPermissions("user:deleted", "user:list", "role:list");
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }
    }

    @Test
    void testMatcher(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        CustomRealm customRealm = new CustomRealm();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置加密封式
        matcher.setHashAlgorithmName("MD5");
        //设置加密次数
        matcher.setHashIterations(3);
        customRealm.setCredentialsMatcher(matcher);
        defaultWebSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123456");

        try {
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("test");
            subject.checkPermissions("user:deleted", "user:list", "role:list");
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }
    }

    @Test
    void testSaltMatcher(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        CustomRealm customRealm = new CustomRealm();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置加密封式
        matcher.setHashAlgorithmName("MD5");
        //设置加密次数
        matcher.setHashIterations(3);
        customRealm.setCredentialsMatcher(matcher);
        defaultWebSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123456");

        try {
            subject.login(usernamePasswordToken);
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
            subject.checkRoles("test");
            subject.checkPermissions("user:deleted", "user:list", "role:list");
            subject.logout();
            System.out.println("执行 logout() 方法后");
            System.out.println("用户认证的状态：isAuthenticated=" + subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名密码不匹配");
        } catch (LockedAccountException lae) {
            System.out.println("账号被锁定");
        } catch (AuthenticationException ae) {
            System.out.println("用户认证异常");
        } catch (UnauthorizedException uae) {
            System.out.println("该用户没有权限访问");
        }
    }

}
