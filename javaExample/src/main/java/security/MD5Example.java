package security;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plaintext = "我是中国人";
        String algorithm = "md5";

        //1.获取MessageDigest实例
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        //2.调用digest方法生成数字摘要
        byte[] digst = messageDigest.digest(plaintext.getBytes());

        //结果转换为16进制字符数组
        char[] md5Hex = Hex.encodeHex(digst);

        for (char c : md5Hex){
            System.out.print(c);
        }
        System.out.println("\nmd5值长度：" + md5Hex.length);
    }
}
