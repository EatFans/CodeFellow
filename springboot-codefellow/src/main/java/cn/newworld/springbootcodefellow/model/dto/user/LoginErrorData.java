package cn.newworld.springbootcodefellow.model.dto.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录失败数据传输实体对象
 * author: EatFan
 */
@Getter
@Setter
public class LoginErrorData {
    private String account;
    private String password;
    private boolean negotiateErrorVisible;
    private String login;
}
