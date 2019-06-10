package com.guanyun.shop.bean.enumeration;

import com.guanyun.shop.bean.annotation.StateMachine;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单售后状态
 */
@Getter
@AllArgsConstructor
public enum OrderAfterSaleState {

    ing("等待商家处理"),
    ship("等待用户发货"),
    receipt("等待商家收货"),
    complete("退款完成"),
    close("退款关闭");

    private String desc;

    public boolean change(OrderAfterSaleState state){
        return OrderAfterSaleState.change(this, state);
    }

    /**
     * 订单售后状态变更
     *
     * 仅退款:
     * ing -> complete
     *     -> close
     *
     * 退货退款:
     * ing -> ship -> receipt -> complete
     *     -> close
     *             -> close
     */
    public static boolean change(OrderAfterSaleState source, OrderAfterSaleState target){
        OrderAfterSaleState[][] flows = new OrderAfterSaleState[][]{
                {ing, complete},
                {ing, ship},
                {ship, receipt},
                {receipt, complete},
                {ing, close},
                {ship, close}
        };

        return StateMachine.change(source, target, flows);
    }
}
