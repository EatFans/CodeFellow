package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 通过用户账号找到该用户信息
     * @param account 用户账号
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    User findUserByAccount(String account);

    /**
     * 通过用户名找到该用户
     * @param username 用户名
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    User findUserByUsername(String username);

    /**
     * 通过用户邮箱找到该用户
     * @param email 用户邮箱
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    User findUserByEmail(String email);

    /**
     * 向用户表插入一条用户数据
     * @param user 用户
     * @return 如果插入成功就返回数值大于0，小于等于0就是未插入成功
     */
    int insertUser(User user);

    /**
     * 通过用户uuid找到该用户
     * @param uuid 用户uuid
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    User findUserByUUID(String uuid);

    // 测试
    void putUserTest(User user);
}
