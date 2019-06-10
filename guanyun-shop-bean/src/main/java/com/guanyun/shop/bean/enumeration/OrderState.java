package com.guanyun.shop.bean.enumeration;

import com.guanyun.shop.bean.annotation.StateMachine;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 */
@Getter
@AllArgsConstructor
public enum OrderState {

    pay("待付款"),
    ship("待发货"),
    receipt("待收货"),
    complete("交易成功"),
    close("交易关闭");

    private String desc;

    public boolean change(OrderState state){
        return OrderState.change(this, state);
    }

    /**
     * 订单状态变更
     *
     * pay -> ship -> receipt -> complete -> refund-close
     *     -> close
     *             -> refund-close
     *                        -> refund-close
     */
    public static boolean change(OrderState source, OrderState target){
        OrderState[][] flows = new OrderState[][]{
                {pay, ship},
                {ship, receipt},
                {receipt, complete},
                {pay, close},
                {ship, close},
                {receipt, close},
                {complete, close}
        };

        return StateMachine.change(source, target, flows);
    }
}
