package com.guanyun.shop.admin.blockChain;

import com.guanyun.shop.bean.enumeration.UserRank;

import java.math.BigDecimal;


public class GuanYun {
    public static void main(String[] args) {

    }

    /**
     * 用户支付下单 计算各级别收益计算
     */
    private void clac(){

        //直接销售奖励 50元
        BigDecimal directSales=new BigDecimal(50);

        //当前(业绩奖 管理奖 专项奖)级别 简称 三奖级别
        UserRank threeRank=null;//默认为下单用户等级


        // 记录子级用户信息
        //

        //1父一级
        // 获得 [直接销售奖]
        // 执行获取[业绩奖 管理奖 专项奖]方法

        //2父二级
        // 如果当前用户为 [酒保] 等级以上 获得 [间接销售奖]
        // 如果当前用户为 [酒师] 等级以上 获得 [辅导奖]   子级总收益的30%
        // 执行获取[业绩奖 管理奖 专项奖]方法

        //3父三级
        // 如果当前用户为 [酒师] 等级以上 获得 [辅导奖]   子级总收益的30%
        // 执行获取[业绩奖 管理奖 专项奖]方法

        //4如果 threeRank 不为空
        //   获取父四级 获取对应 业绩奖-管理奖-专项奖



        //5获取[业绩奖 管理奖 专项奖]规则
        // 如果当前用户为 [酒商->酒官->酒帝] 等级以上 获得对应 业绩奖-管理奖-专项奖
        //   如果平级 例:酒商->酒官->酒官 则第二个酒官获得第一个酒官收益的10%  是总收益的10%! threeRank设置为空
        //   如果下级 则停止 (业绩奖 管理奖 专项奖) threeRank设置为空


    }

    /**
     * 重新计算父级用户等级
     */
    private void userRank(){

        // 获取当前用户的父一级 判断是否存在
        // 增加销售单数 增加团队业绩
        UserRank currentRank= UserRank.visitor;

        // 判读是否符合下一等级升级条件
        if (currentRank.equals(UserRank.visitor)){
            // 销售1单 达成升级
        }else if (currentRank.equals(UserRank.drinker)){
            // 销售3单 达成升级
        }else if (currentRank.equals(UserRank.bartender)){
            // 销售5单 达成升级
        }else if (currentRank.equals(UserRank.winemaker)){
            // 5个酒师 销售60单以上
        }else if (currentRank.equals(UserRank.wineDealer)){
            // 3个酒商 2个酒师 团队业绩1000W
        }else if (currentRank.equals(UserRank.wineOfficer)){
            // 2个酒官 3个酒商 团队业绩5000W
        }else if (currentRank.equals(UserRank.wineEmperor)) {
            //
        }

//        do {
            // 获取父一级的父级
            // 增加团队业绩
//        }while ()



        ////////////////////////////////////////////////////////////
    }
}
