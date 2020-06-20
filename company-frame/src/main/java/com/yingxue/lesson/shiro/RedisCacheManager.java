package com.yingxue.lesson.shiro;

import com.yingxue.lesson.service.RedisService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author Saber污妖王
 * TODO: Shiro 的 Redis 缓存管理器
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/26
 * @package com.yingxue.lesson.shiro
 */
public class RedisCacheManager implements CacheManager {
    @Resource
    private RedisService redisService;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new RedisCache<>(s, redisService);
    }
}
