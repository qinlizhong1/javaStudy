package security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MACExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String plaintext = "我是中国人";
        String algorithm = "HmacSHA256";

        //1.1 初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);

        //1.2 构建秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        //1.3 获得秘钥
        byte[] key = secretKey.getEncoded();

        //1.4 还原秘钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, algorithm);

        //2 实例化Mac
        Mac mac = Mac.getInstance(algorithm);

        //3 初始化Mac
        mac.init(secretKeySpec);

        //4 获取消息摘要
        byte[] digst = mac.doFinal(plaintext.getBytes());

        char[] sha256Hex = Hex.encodeHex(digst);

        for (char c : sha256Hex){
            System.out.print(c);
        }
        System.out.println("\nHmacSHA256值长度：" + sha256Hex.length);
    }
}
