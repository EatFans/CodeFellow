package cn.newworld.springbootcodefellow.constant.consist;

/**
 * 账号状态常量类
 * author: EatFan
 */
public final class AccountStatus {

    public static final String ACTIVE = "Active";                // 激活状态
    public static final String DISABLED = "Disabled";            // 禁用状态
    public static final String PENDING = "Pending";              // 待激活验证状态
    public static final String LOCKED = "Locked";                // 锁定状态
    public static final String SUSPENDED = "Suspended";          // 暂停使用状态
    public static final String BANNED = "Banned";                // 被禁止使用状态
    public static final String INACTIVE = "Inactive";            // 非活跃状态
    public static final String LIMITED_ACCESS = "Limited Access";     // 限制访问状态

    private AccountStatus() {
        // 私有构造函数，防止实例化
    }

}
