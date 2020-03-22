package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/21
 * @Description:com.yingxue.lesson.config
 * @version:1.0
 */
@Configuration
public class RedisConfig {
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.minIdle}")
    private int minIdle;
    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.maxWait}")
    private int maxWait;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;

    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig jedisPoolConfig = new  JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        return new JedisPool(jedisPoolConfig,host,port,timeout);
    }
}
