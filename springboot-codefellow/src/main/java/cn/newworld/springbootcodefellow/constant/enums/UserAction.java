package cn.newworld.springbootcodefellow.constant.enums;


/**
 * 用户操作的枚举类
 * author: EatFan
 */
public enum UserAction {
    LOGIN("login"),                      // 登录
    LOGOUT("logout"),                    // 退出登录
    REGISTER("register"),                // 注册
    RESET_PASSWORD("reset_password"),  // 重置密码
    ACTIVATE_ACCOUNT("activate_account"),// 激活账号
    UPDATE_PROFILE("update_profile"),    // 更新个人资料
    CHANGE_PASSWORD("change_password");  // 修改密码

    private final String action;

    UserAction(String action) {
        this.action = action;
    }

    public String toString() {
        return action;
    }
}