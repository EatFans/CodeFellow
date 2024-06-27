package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * 用户数据映射接口
 */
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

    /**
     * 通过用户uuid、账号、用户名找到该用用户
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果查询到了就返回该用户User对象，否则就返回null
     */
    User findUserByUuidAndAccountAndUsername(String uuid,String account,String username);

    /**
     * 更新用户账号状态
     * @param uuid 被更新的用户uuid
     * @param account 被更新的用户账号
     * @param username 被更新的用户名
     * @param status 更新后的账号状态
     * @return 如果更新成功就返回true，否则就返回false
     */
    boolean updateStatus(String uuid, String account, String username,String status);

    /**
     * 更新用户账号验证情况
     * @param uuid 被更新的用户uuid
     * @param account 被更新的用户账号
     * @param username 被更新的用户名
     * @param verification 更新后的账号验证情况
     * @return 如果更新成功就返回true，否则就返回false
     */
    boolean updateVerification(String uuid,String account,String username,boolean verification);

    /**
     *  更新登录时间
     * @param uuid 被更新的用户uuid
     * @param account 被更新的用户账号
     * @param username 被更新的用户名
     * @param newTime 更新后最新的时间
     * @return 如果更新成功就返回true，否则就返回false
     */
    boolean updateLoginTime(String uuid, String account, String username, Date newTime);

    /**
     * 更新密码
     * @param uuid 被更新的用户uuid
     * @param account 被更新的用户账号
     * @param username 被更新的用户名
     * @param password 更新后的密码
     * @return 如果更新成功就返回true，否则就返回false
     */
    boolean updatePassword(String uuid, String account, String username, String password);

    /**
     * 通过手机号来查询用户
     * @param phoneNumber 手机号
     * @return 如果查询到就返回该用户，否则就返回null
     */
    User findUserByPhoneNumber(String phoneNumber);
}
