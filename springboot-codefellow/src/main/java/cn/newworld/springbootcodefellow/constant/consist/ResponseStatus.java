package cn.newworld.springbootcodefellow.constant.consist;

/**
 * 请求响应状态常量类
 * author: EatFan
 */
public class ResponseStatus {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String ACCOUNT_EXISTS = "account_exists";
    public static final String EMAIL_EXISTS = "email_exists";
    public static final String USERNAME_EXISTS = "username_exists";

    // 私有构造函数防止实例化
    private ResponseStatus() {
        throw new UnsupportedOperationException("This is a constants class and cannot be instantiated");
    }
 }
