package cn.newworld.springbootcodefellow.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Api接口响应体数据实体类
 * author: EatFan
 */
@Setter
@Getter
public class ApiResponse {
    private String status;
    private String message;
    private Object data;

    public ApiResponse(String status, String message){
        this.status = status;
        this.message = message;
    }
    public ApiResponse(String status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
