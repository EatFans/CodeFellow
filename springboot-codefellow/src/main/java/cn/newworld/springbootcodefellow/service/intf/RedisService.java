package cn.newworld.springbootcodefellow.service.intf;

import java.util.concurrent.TimeUnit;

/**
 * Redis业务接口
 * author: EatFan
 */
public interface RedisService {
    /**
     * 存储一个键值对到Redis中，并设置上过期时间
     * @param key 存储的键
     * @param value 存储的值
     * @param timeout 过期时间
     * @param unit 时间单位
     */
    void set(String key, Object value, long timeout, TimeUnit unit);

    /**
     * 从Redis中获取指定键的值
     * @param key 要获取值的键
     * @return 返回存储在键中的值，如果键不存在则返回null
     */
    Object get(String key);

    /**
     * 从Redis中删除指定键
     * @param key 要删除的键
     * @return 如果键被删除则返回true，如果键不存在则就返回false
     */
    boolean delete(String key);

    /**
     * 检查指定键是否存在
     * @param key 要检查的键
     * @return 如果键存在则返回true，否则返回false
     */
    boolean exists(String key);

    /**
     * 为指定键设置过期时间
     * @param key 要设置过期时间的键
     * @param timeout 过期时间
     * @param unit 时间单位
     * @return 如果成功设置过期时间则返回true，否则返回false
     */
    boolean expire(String key, long timeout, TimeUnit unit);

    /**
     * 获取指定键的过期时间
     * @param key 要获取过期时间的键
     * @param unit 时间单位
     * @return 返回键的剩余过期时间，如果键不存在或没有设置过期时间则返回-1
     */
    long getExpire(String key, TimeUnit unit);

    /**
     * 通过值在Redis中找到键key
     * @param value 值
     * @return 返回key键字符串
     */
    String getKey(Object value);

    /**
     * 检查指定的值是否存在于Redis中
     * @param value 要检查的值
     * @return 如果值存在则返回true，否则返回false
     */
    boolean valueExists(Object value);
}
