package security;

import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plaintext = "我是中国人";
        String algorithm = "sha-256";

        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        byte[] digst = messageDigest.digest(plaintext.getBytes());

        char[] sha256Hex = Hex.encodeHex(digst);

        for (char c : sha256Hex){
            System.out.print(c);
        }
        System.out.println("\nsha-256值长度：" + sha256Hex.length);
    }
}
