package com.guanyun.shop.admin.blockChain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
    /**
     * 私钥
     */
    public PrivateKey privateKey;
    /**
     * 公钥
     */
    public PublicKey publicKey;

    public Wallet() {
        generateKeyPair();
    }

    /**
     * 生成 公钥-私钥
     */
    public void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}