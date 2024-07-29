package cn.newworld.springbootcodefellow.model.dto.user;

import lombok.Data;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * token令牌响应数据体
 * author: EatFan
 */
@Data
public class TokenResponse {
    private String token;
    private long timeout;
    private TimeUnit timeUnit;

    public TokenResponse(String token, long timeout, TimeUnit timeUnit){
        this.token = token;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }
}
