package com.guanyun.shop.provider.config;

import com.guanyun.shop.bean.enumeration.ErrorCode;
import lombok.Data;

/**
 * 业务异常
 */
@Data
public class FlowException extends RuntimeException {

    private String message;

    private ErrorCode errorCode;

    public FlowException() {
        super();
    }

    public FlowException(String message) {
        super(message);
        this.message = message;
    }

    public FlowException(String message, ErrorCode errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
