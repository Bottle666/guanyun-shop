package com.guanyun.shop.bean.enumeration;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 错误码
 */
@RequiredArgsConstructor
public enum ErrorCode {

    normal(200),//通用返回值
    forceUpdate(202),//强制更新
    unauthorized(401),//未授权
    forbidden(403),//拒绝访问
    notMobile(500);//未绑定手机号

    @Getter
    @NonNull
    private Integer value;
}
