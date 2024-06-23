package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.mapper.UserMapper;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户业务实现类
 * author: EatFan
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /**
     * 检查用户账号是否已经存在
     * @param account 用户账号
     * @return 如果用户账号存在就返回true，否则返回false
     */
    @Override
    public boolean isAccountExists(String account) {
        User userByAccount = userMapper.findUserByAccount(account);
        return userByAccount != null;
    }

    /**
     * 检查用户名是否已经存在
     * @param username 用户名
     * @return 如果用户名存在就返回true，否则就返回false
     */
    @Override
    public boolean isUsernameExists(String username){
        User userByUsername = userMapper.findUserByUsername(username);
        return userByUsername != null;
    }

    /**
     * 检查用户邮箱是否已经存在
     * @param email 用户邮箱
     * @return 如果用户邮箱存在就返回true，否则返回false
     */
    @Override
    public boolean isEmailExists(String email) {
        User userByEmail = userMapper.findUserByEmail(email);
        return userByEmail != null;
    }

    /**
     * 创建用户
     * @param user 需要创建的用户对象
     * @return 如果创建成功就返回true，创建失败就返回false
     */
    @Override
    public boolean create(User user) {
        try {
            int rowsAffected = userMapper.insertUser(user);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 可以在这里处理异常情况，例如日志记录等
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过uuid来获取用户user对象
     * @param uuid 用户uuid
     * @return 如果获取到了就返回user对象，否则就返回null
     */
    @Override
    public User getUserByUUID(String uuid) {
        return userMapper.findUserByUUID(uuid);
    }

    /**
     * 通过用户账号来获取该用户user对象
     * @param account 用户账号
     * @return 如果获取到了就返回user对象，否则就返回null
     */
    @Override
    public User getUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    /**
     * 验证激活用户账号
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果通过uuid、账号、用户名都验证成功，
     */
    @Override
    public boolean verifyUserAccount(String uuid, String account, String username) {
        User user = userMapper.findUserByUuidAndAccountAndUsername(uuid, account, username);
        // 检查用户是否存在
        if (user != null){
            // 检查用户是否已经验证过了
            if (!user.getIsVerification()){
                // 更新用户账号状态和验证情况
                boolean statusFlag = userMapper.updateStatus(uuid, account, username, AccountStatus.ACTIVE);
                boolean verificationFlag = userMapper.updateVerification(uuid, account, username, true);
                return statusFlag && verificationFlag;
            }
        }
        return false;
    }

    /**
     * 更新用户登录时间
     * @param user 被更新的用户
     * @return 如果成功更新用户登录时间就返回true，否则就返回false
     */
    @Override
    public boolean updateUserLoginTime(User user) {
        return userMapper.updateLoginTime(user.getUuid(), user.getAccount(), user.getUsername(), new Date());
    }
}
