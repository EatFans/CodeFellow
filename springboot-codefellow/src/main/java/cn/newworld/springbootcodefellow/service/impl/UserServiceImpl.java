package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.mapper.UserMapper;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Boolean isAccountExists(String account) {
        User userByAccount = userMapper.findUserByAccount(account);
        return userByAccount != null;
    }

    /**
     * 检查用户名是否已经存在
     * @param username 用户名
     * @return 如果用户名存在就返回true，否则就返回false
     */
    @Override
    public Boolean isUsernameExists(String username){
        User userByUsername = userMapper.findUserByUsername(username);
        return userByUsername != null;
    }

    /**
     * 检查用户邮箱是否已经存在
     * @param email 用户邮箱
     * @return 如果用户邮箱存在就返回true，否则返回false
     */
    @Override
    public Boolean isEmailExists(String email) {
        User userByEmail = userMapper.findUserByEmail(email);
        return userByEmail != null;
    }


    @Override
    public void create(User user) {

    }
}
