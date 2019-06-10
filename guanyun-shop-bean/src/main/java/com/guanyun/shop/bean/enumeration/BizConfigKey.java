package com.guanyun.shop.bean.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 应用配置key
 */
@Getter
@AllArgsConstructor
public enum BizConfigKey {

    //IOS版本
    iosVersion(DataType.string),

    //安卓版本
    androidVersion(DataType.string),

    //强制更新开关
    forceUpdateToggle(DataType.boole),

    //平台默认运费
    defaultFreight(DataType.decimal),

    //火力值
    fireNumber(DataType.integer);

    /**
     * 数据类型
     */
    private DataType dataType;
}
