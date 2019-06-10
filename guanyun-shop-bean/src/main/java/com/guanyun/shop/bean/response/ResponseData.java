package com.guanyun.shop.bean.response;

import com.guanyun.shop.bean.enumeration.ErrorCode;
import lombok.Data;

@Data
public class ResponseData<T> {

    private boolean succeed;

    private T data;

    private Error error;
    
    public static <T> ResponseData<T> succeed(){
        return succeed(null);
    }

    public static <T> ResponseData<T> succeed(T data){
        ResponseData<T> result = new ResponseData<T>();
        result.setSucceed(true);
        result.setData(data);
        result.setError(null);

        return result;
    }

    public static <T> ResponseData<T> fail(String description){
        return fail(description, ErrorCode.normal);
    }
    
    public static <T> ResponseData<T> fail(String description, ErrorCode errorCode){
        ResponseData<T> result = new ResponseData<T>();
        result.setSucceed(false);
        result.setData(null);

        Error error= new Error();
        error.setCode(errorCode == null ? ErrorCode.normal.getValue() : errorCode.getValue());
        error.setDescription(description);
        result.setError(error);
        return result;
    }

    @Data
    public static class Error {

        private Integer code;//错误码
        private String description;//错误描述信息
    }
}
