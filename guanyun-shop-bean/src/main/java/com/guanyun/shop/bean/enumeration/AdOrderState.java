package com.guanyun.shop.bean.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 */
@Getter
@AllArgsConstructor
public enum AdOrderState {

    pay("待付款"),
    complete("交易成功");

    private String desc;
}
