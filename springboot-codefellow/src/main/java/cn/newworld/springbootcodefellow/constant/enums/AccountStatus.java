package cn.newworld.springbootcodefellow.constant.enums;

/**
 * 账号状态 枚举类
 * author: EatFan
 */
public enum AccountStatus {
    ACTIVE("Active"),        // 激活状态
    DISABLED("Disabled"),    // 禁用状态
    PENDING("Pending"),      // 待审核状态
    DELETED("Deleted"),      // 已删除状态
    LOCKED("Locked"),        // 锁定状态
    EXPIRED("Expired"),      // 过期状态
    SUSPENDED("Suspended"),  // 暂停使用状态
    BANNED("Banned"),        // 被禁止使用状态
    INACTIVE("Inactive"),    // 非活跃状态
    PENDING_PAYMENT("Pending Payment"),       // 待支付状态
    LIMITED_ACCESS("Limited Access");         // 限制访问状态


    private final String value;

    AccountStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
