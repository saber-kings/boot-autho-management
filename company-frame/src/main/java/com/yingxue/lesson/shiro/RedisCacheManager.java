package com.yingxue.lesson.shiro;

import com.yingxue.lesson.service.RedisService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @Author: Saber污妖王
 * TODO: Shiro 的 Redis 缓存管理器
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/26
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class RedisCacheManager implements CacheManager {
    @Resource
    private RedisService redisService;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new RedisCache<>(s, redisService);
    }
}
