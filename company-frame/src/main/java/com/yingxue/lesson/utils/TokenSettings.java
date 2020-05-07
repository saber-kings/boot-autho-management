package com.yingxue.lesson.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @Author: Saber污妖王
 * TODO: JWT 配置读取工具类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class TokenSettings {
    private String secretKey;
    private Duration accessTokenExpireTime;
    private Duration refreshTokenExpireTime;
    private Duration refreshTokenExpireAppTime;
    private String issuer;
}
