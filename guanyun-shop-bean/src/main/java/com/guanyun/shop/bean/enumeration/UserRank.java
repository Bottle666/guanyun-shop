package com.guanyun.shop.bean.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户等级
 */
@Getter
@AllArgsConstructor
public enum UserRank {
    visitor("游客"),
    drinker("酒客"),
    bartender("酒保"),
    winemaker("酒师"),
    wineDealer("酒商"),
    wineOfficer("酒官"),
    wineEmperor("酒帝");
    private String desc;
}
