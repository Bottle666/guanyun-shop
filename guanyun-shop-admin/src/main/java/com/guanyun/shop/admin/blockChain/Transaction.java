package com.guanyun.shop.admin.blockChain;

import java.security.*;
import java.util.ArrayList;

/**
 * 交易类
 */
public class Transaction {
    public String transactionId; // 交易的hash编号
    public PublicKey sender; // 付款人地址 公钥
    public PublicKey reciepient; // 接受人地址 公钥
    public float value;//转移金额
    public byte[] signature; // 数字签名，防止其他人从我们的钱包中发送资金、
    //输入列表
    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    //输出列表
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    //多少个交易已经被创建
    private static int sequence = 0;

    //构造器
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    // 计算交易的hash值（用于交易编号）
    private String calulateHash() {
        sequence++; //增加sequence，用来防治两个不同的交易有相同的hash值
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(reciepient) +
                        Float.toString(value) + sequence
        );
    }

    //签名所有我们不想被篡改的数据
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    //验证我们已签名的数据没有被窜给过
    public boolean verifiySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender, data, signature);
    }
}