package com.guanyun.shop.bean.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章操作-类型
 */
@Getter
@AllArgsConstructor
public enum ArticleActionType {

    read("只读"),
    finish("读完"),
    share("分享"),
    like("点赞"),
    comment("评价");

    private String desc;
}
