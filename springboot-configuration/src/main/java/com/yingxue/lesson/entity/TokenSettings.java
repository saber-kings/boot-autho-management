package com.yingxue.lesson.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.entity
 * @version:1.0
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class TokenSettings {

    private String secretKey;
    private String issuer;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "TokenSettings{" +
                "secretKey='" + secretKey + '\'' +
                ", issuer='" + issuer + '\'' +
                '}';
    }

}
