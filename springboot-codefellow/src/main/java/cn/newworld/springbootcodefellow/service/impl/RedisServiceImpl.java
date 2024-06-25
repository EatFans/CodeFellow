package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.service.intf.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis 业务类
 * 用于存储和读取Redis数据的服务类
 * author: EatFan
 */
@Service
public class RedisServiceImpl implements RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 存储一个键值对到Redis中，并设置上过期时间
     * @param key 存储的键
     * @param value 存储的值
     * @param timeout 过期时间
     * @param unit 时间单位
     */
    @Override
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }

    /**
     * 从Redis中获取指定键的值
     * @param key 要获取值的键
     * @return 返回存储在键中的值，如果键不存在则返回null
     */
    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 从Redis中删除指定键。
     *
     * @param key 要删除的键
     * @return 如果键被删除则返回true，如果键不存在则返回false
     */
    @Override
    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 检查指定键是否存在
     * @param key 要检查的键
     * @return 如果键存在则返回true，否则返回false
     */
    @Override
    public boolean exists(String key){
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 为指定键设置过期时间
     * @param key 要设置过期时间的键
     * @param timeout 过期时间
     * @param unit 时间单位
     * @return 如果成功设置过期时间则返回true，否则返回false
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit unit){
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

    /**
     * 获取指定键的过期时间
     * @param key 要获取过期时间的键
     * @param unit 时间单位
     * @return 返回键的剩余过期时间，如果键不存在或没有设置过期时间则返回-1
     */
    @Override
    public long getExpire(String key, TimeUnit unit){
        Long expire = redisTemplate.getExpire(key, unit);
        return (expire != null) ? expire : -1;
    }

    /**
     * 通过值在Redis中找到键key
     * @param value 值
     * @return 返回key键字符串
     */
    @Override
    public String getKey(Object value) {
        Set<String> keys = redisTemplate.keys("*");
        if (keys != null){
            for (String key : keys){
                Object storedValue = redisTemplate.opsForValue().get(key);
                if (storedValue != null){
                    if (storedValue.equals(value))
                        return key;
                }
            }
        }
        return null;
    }

    /**
     * 检查指定的值是否存在于Redis中
     * @param value 要检查的值
     * @return 如果值存在则返回true，否则返回false
     */
    @Override
    public boolean valueExists(Object value) {
        String key = getKey(value);
        return key != null;
    }
}
