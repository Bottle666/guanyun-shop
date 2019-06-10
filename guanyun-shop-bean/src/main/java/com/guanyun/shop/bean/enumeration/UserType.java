package com.guanyun.shop.bean.enumeration;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 操作用户类型
 */
@RequiredArgsConstructor
public enum UserType {

    user("用户"),
    merchant("商家"),
    admin("管理员");

    @Getter
    @NonNull
    private String desc;
}
