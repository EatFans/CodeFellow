package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 通过用户账号找到该用户信息
     * @param account 用户账号
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    @Select("SELECT * FROM user WHERE account = #{account}")
    User findUserByAccount(@Param("account") String account);

    /**
     * 通过用户名找到该用户
     * @param username 用户名
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(@Param("username") String username);

    /**
     * 通过用户邮箱找到该用户
     * @param email 用户邮箱
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    @Select("SELECT * FROM user WHERE email = #{ email }")
    User findUserByEmail(@Param("email") String email);
}
