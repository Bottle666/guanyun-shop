package com.guanyun.shop.admin.blockChain;

import lombok.Setter;

import java.util.Date;

/**
 * 区块
 */
public class Block {

    //哈希
    public String hash;
    //上一个哈希
    public String previousHash;
    //数据
    @Setter
    public String data; //our data will be a simple message.
    //时间轴
    private long timeStamp; //as number of milliseconds since 1/1/1970.
    //矿工
    private int nonce;

    //Block Constructor.
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }

    /**
     * 哈希计算函数
     *
     * @return
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    /**
     * 挖矿
     *
     * @param difficulty
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}