package com.guanyun.shop.bean.annotation;

/**
 * 状态机
 */
public class StateMachine {

    /**
     * 状态变更
     */
    public static <T> boolean change(T source, T target, T[][] flows){
        for (T[] flow : flows) {
            if (flow[0].equals(source) && flow[1].equals(target)) {
                return true;
            }
        }

        return false;
    }
}
