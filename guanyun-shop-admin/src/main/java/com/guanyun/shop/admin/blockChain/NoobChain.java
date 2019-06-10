package com.guanyun.shop.admin.blockChain;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.ArrayList;

/**
 * 参考文献
 * https://blog.csdn.net/u010093971/article/details/79366801
 */
public class NoobChain {

    //区块链
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    //难度
    public static int difficulty = 5;

    public static Wallet walletA;
    public static Wallet walletB;

    public static void main(String[] args) {

//========简单模式
//        Block genesisBlock = new Block("Hi im the first block", "0");
//        System.out.println("Hash for block 1 : " + genesisBlock.hash + "-- data: " + genesisBlock.data);
//
//        Block secondBlock = new Block("Yo im the second block", genesisBlock.hash);
//        System.out.println("Hash for block 2 : " + secondBlock.hash + "-- data: " + secondBlock.data);
//
//        Block thirdBlock = new Block("Hey im the third block", secondBlock.hash);
//        System.out.println("Hash for block 3 : " + thirdBlock.hash + "-- data: " + thirdBlock.data);

//========内存模式
//        blockchain.add(new Block("Hi im the first block", "0"));
//        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
//        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
//
//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println("\nThe block chain: ");
//        System.out.println(blockchainJson);


//========挖矿模式
//        blockchain.add(new Block("Hi im the first block", "0"));
//        System.out.println("Trying to Mine block 1... ");
//        blockchain.get(0).mineBlock(difficulty);
//
//        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
//        System.out.println("Trying to Mine block 2... ");
//        blockchain.get(1).mineBlock(difficulty);
//
//        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
//        System.out.println("Trying to Mine block 3... ");
//        blockchain.get(2).mineBlock(difficulty);
//
//        blockchain.get(2).setData("篡改数据");
//
//        blockchain.add(new Block("Ha im the Fourth block",blockchain.get(blockchain.size()-1).hash));
//        System.out.println("Trying to Mine block 4... ");
//        blockchain.get(3).mineBlock(difficulty);
//
//
//        System.out.println("\nBlockchain is Valid: " + isChainValid());
//
//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println("\nThe block chain: ");
//        System.out.println(blockchainJson);

        //调用Bouncey castle作为安全性的提供类
        Security.addProvider(new BouncyCastleProvider());
        //创建两个钱包
        walletA = new Wallet();
        walletB = new Wallet();
        //测试公钥和私钥
        System.out.println("Private and public keys:");
        System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
        System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
        //创建一个交易从WalletA地址到walletB地址
        Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 5, null);
        //用wallectA的私钥进行签名
        transaction.generateSignature(walletA.privateKey);
        //通过wallectA的公钥验证签名是否工作
        System.out.println("Is signature verified");
        System.out.println(transaction.verifiySignature());

    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}