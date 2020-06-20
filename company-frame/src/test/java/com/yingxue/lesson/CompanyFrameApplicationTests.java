package com.yingxue.lesson;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.utils.BeanUtils;
import com.yingxue.lesson.vo.req.UserUpdateReqVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.UUID;

@SpringBootTest
class CompanyFrameApplicationTests {
    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
        Set<String> keys = redisService.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    void testBeanUtils() {
        SysUser sysUser = new SysUser();
        sysUser.setId(UUID.randomUUID().toString());
        sysUser.setUsername("测试");
        sysUser.setPassword("666666");
        sysUser.setPhone("1234567890");
        sysUser.setDeptId(UUID.randomUUID().toString());
        sysUser.setStatus(0);
        sysUser.setSex(0);
        sysUser.setDeleted(0);
        long bigStart = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 10000; j++) {
                UserUpdateReqVO vo = new UserUpdateReqVO();
                BeanUtils.copyProperties(sysUser, vo);
            }
            long end = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "万次对象拷贝结束，用时: " + (end - start) + " 毫秒");
        }
        long bigEnd = System.currentTimeMillis();
        System.out.println("所有对象拷贝结束，用时: " + (bigEnd - bigStart) + " 毫秒");
    }
}
