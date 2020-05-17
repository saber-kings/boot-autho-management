package com.yingxue.lesson.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.mapper.SysLogMapper;
import com.yingxue.lesson.utils.HttpContextUtils;
import com.yingxue.lesson.utils.IPUtils;
import com.yingxue.lesson.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Saber污妖王
 * TODO: 切面类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.aop.aspect
 * @Version: 0.0.1
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
    //环绕增强
    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * 配置织入点(以 @MyLog注 解为标志)
     * 只要出现 @MyLog 注解都会进入
     */
    @Pointcut("@annotation(com.yingxue.lesson.aop.annotation.MyLog)")
    public void logPointCut() {
    }

    /**
     * 环绕增强
     *
     * @param point 切入点
     * @return 执行结果
     * @throws Throwable 中间若出错，抛出异常
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        try {
            saveSysLog(point, time);
        } catch (Exception e) {
            log.error("Exception,{}", e.getLocalizedMessage());
        }
        return result;
    }

    /**
     * 把日志保存
     *
     * @param joinPoint 切入点
     * @param time      耗时
     */
    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            //注解上的描述
            sysLog.setOperation(myLog.title() + "-" + myLog.action());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //打印该方法耗时时间
        log.info("请求{}.{}耗时：{}毫秒", className, methodName, time);
        try {
            //请求的参数
            Object[] args = joinPoint.getArgs();
            // 如果参数类型是请求和响应的http，则不需要拼接【这两个参数，使用 JSON.toJSONString() 转换会抛异常】
            StringBuilder params = new StringBuilder(0);
            if (args.length != 0) {
                for (Object arg : args) {
                    if (arg instanceof HttpServletRequest || arg instanceof HttpServletResponse) {
                        continue;
                    }
                    params.append(arg == null ? "" : JSON.toJSONString(arg));
                }
            }
            sysLog.setParams(params.toString());
        } catch (Exception e) {
            log.error("Exception,{}", e.getLocalizedMessage());
        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        log.info("Ip{}，接口地址{}，请求方式{}，入参：{}", sysLog.getIp(), request.getRequestURL(), request.getMethod(), sysLog.getParams());
        //用户名
        String token = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(token);
        String username = JwtTokenUtil.getUserName(token);
        sysLog.setUsername(username);
        sysLog.setUserId(userId);
        sysLog.setTime((int) time);
        sysLog.setId(UUID.randomUUID().toString());
        sysLog.setCreateTime(new Date());
        log.info(sysLog.toString());
        sysLogMapper.insertSelective(sysLog);

    }
}
