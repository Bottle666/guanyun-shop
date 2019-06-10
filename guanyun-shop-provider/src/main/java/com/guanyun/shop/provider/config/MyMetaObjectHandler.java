package com.guanyun.shop.provider.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 公共字段自动填充
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createAt", LocalDateTime.now(), metaObject);
        setFieldValByName("updateAt", LocalDateTime.now(), metaObject);
        this.digestFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateAt", LocalDateTime.now(), metaObject);
        this.digestFill(metaObject);
    }

    /**
     * 安全摘要填充
     */
    private void digestFill(MetaObject metaObject){
//        Object id = getFieldValByName("id", metaObject);
//        if(id == null) return;
//
//        if(hasUpdateDigest("moneyDigest", metaObject)){
//            BigDecimal money = new BigDecimal(getFieldValByName("money", metaObject).toString());
//            String moneyDigest = AESUtils.encrypt(Integer.valueOf(id.toString()), money);
//            setFieldValByName("moneyDigest", moneyDigest, metaObject);
//        }
//
//        if(hasUpdateDigest("ingMoneyDigest", metaObject)){
//            BigDecimal money = new BigDecimal(getFieldValByName("ingMoney", metaObject).toString());
//            String ingMoneyDigest = AESUtils.encrypt(Integer.valueOf(id.toString()), money);
//            setFieldValByName("ingMoneyDigest", ingMoneyDigest, metaObject);
//        }
    }

    /**
     * 是否更新摘要
     */
    private boolean hasUpdateDigest(String name, MetaObject metaObject){
        String origin = name.replace("Digest", "");
        return getFieldValByName(name, metaObject) != null &&
                getFieldValByName(origin, metaObject) != null;
    }
}
