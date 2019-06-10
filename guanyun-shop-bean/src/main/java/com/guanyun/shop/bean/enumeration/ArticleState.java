package com.guanyun.shop.bean.enumeration;

import com.guanyun.shop.bean.annotation.StateMachine;

/**
 * 文章状态
 */
public enum ArticleState {

    pending,//待审核
    rejected,//审核不通过
    waiting,//等候区
    online,//上线
    offline;//下线

    public boolean change(ArticleState state){
        return ArticleState.change(this, state);
    }

    /**
     * 文章状态变更
     *
     * pending -> rejected
     * pending -> online
     * pending -> waiting -> online -> offline
     */
    public static boolean change(ArticleState source, ArticleState target){
        ArticleState[][] flows = new ArticleState[][]{
                {pending, rejected},
                {pending, online},
                {pending, waiting},
                {waiting, online},
                {online, offline}
        };

        return StateMachine.change(source, target, flows);
    }
}
