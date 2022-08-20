package security;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class DESExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        String plaintext = "我是中国人";
        System.out.println("明文:" + plaintext);

        // 加密算法
        String algorithm = "DES";

        // 转换模式
        String transformation = "DES";

        //1.1 初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);

        //1.2 初始化秘钥长度
        //keyGenerator.init(56);

        //1.3 构建秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        //1.4 获得秘钥
        byte[] key = secretKey.getEncoded();

        //1.5 实例化DES秘钥材料
        DESKeySpec desKeySpec = new DESKeySpec(key);

        //1.6 实例化秘钥工厂
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);

        //1.7 生成DES秘钥
        SecretKey desSecretKey = secretKeyFactory.generateSecret(desKeySpec);
        System.out.println("秘钥：" +  Base64.getEncoder().encodeToString(desSecretKey.getEncoded()));

        //2.1 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        //2.2 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, desSecretKey);

        //3 加密
        byte[] encrypt = cipher.doFinal(plaintext.getBytes());
        System.out.println("秘文：" + Base64.getEncoder().encodeToString(encrypt));

        //4 解密
        cipher.init(Cipher.DECRYPT_MODE, desSecretKey);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("解密结果：" + new String(decrypt));
    }
}
