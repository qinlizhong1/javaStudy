package Base64;

import java.util.Base64;

class Base64Test{
    //标准Base64编解码
    public void test0(){
        //编码
        System.out.println(Base64.getEncoder().encodeToString("Hello!!".getBytes()));

        //解码
        byte[] bytes = Base64.getDecoder().decode("SGVsbG8hIQ==");
        for (byte b : bytes){
            System.out.print((char)b);
        }
    }

    //URL Base64算法
    public void test1(){
        System.out.println();
        String value = "Hello!!中&";
        System.out.println(Base64.getEncoder().encodeToString(value.getBytes()));
        System.out.println(Base64.getUrlEncoder().encodeToString(value.getBytes()));
    }
}

public class Base64Example {
    public static void main(String[] args) {
        Base64Test base64Test = new Base64Test();
        base64Test.test0();
        base64Test.test1();
    }
}
