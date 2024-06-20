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

    //TODO: 待写
    int insertUser(User user);

    // 测试
    void putUserTest(User user);
}
