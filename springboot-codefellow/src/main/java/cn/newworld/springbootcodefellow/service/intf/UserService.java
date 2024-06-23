package cn.newworld.springbootcodefellow.service.intf;


import cn.newworld.springbootcodefellow.model.entity.User;

/**
 * 用户业务接口
 * author: EatFan
 */
public interface UserService {
    /**
     * 检查用户账号是否已经存在
     * @param account 用户账号
     * @return 如果用户账号存在就返回true，否则返回false
     */
    Boolean isAccountExists(String account);

    /**
     * 检查用户名是否已经存在
     * @param username 用户名
     * @return 如果用户名存在就返回true，否则返回false
     */
    Boolean isUsernameExists(String username);

    /**
     * 检查用户邮箱是否已经存在
     * @param email 用户邮箱
     * @return 如果用户邮箱存在就返回true，否则返回false
     */
    Boolean isEmailExists(String email);

    /**
     * 创建用户
     * @param user 用户数据对象
     * @return 如果创建成功就返回true，否则就返回false
     */
    Boolean create(User user);

    /**
     * 通过uuid来获取用户user对象
     * @param uuid 用户uuid
     * @return 如果获取到了就返回user对象，否则就返回null
     */
    User getUserByUUID(String uuid);

    /**
     * 通过用户账号来获取该用户user对象
     * @param account 用户账号
     * @return 如果获取到了就返回user对象，否则就返回null
     */
    User getUserByAccount(String account);

    /**
     * 验证激活用户账号
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果通过uuid、账号、用户名都验证成功，
     */
    Boolean verifyUserAccount(String uuid,String account, String username);

    /**
     * 更新用户登录时间
     * @param user 被更新的用户
     * @return 如果成功更新用户登录时间就返回true，否则就返回false
     */
    Boolean updateUserLoginTime(User user);
}
