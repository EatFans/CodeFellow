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
}
