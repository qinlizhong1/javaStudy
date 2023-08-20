package protobuf.p2;


import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

class ProtobufTest{
    private static Stu.Student.Builder stuBuilder = null;
    static {
        stuBuilder = Stu.Student.newBuilder();
        stuBuilder.setId(1)
                .setBoy(true)
                .setName("张一")
                .build();

        stuBuilder.addListString("ListString-1")
                .addListString("ListString-2").build();

        stuBuilder.putMapString("k1", "v1")
                .putMapString("k2", "v2")
                .build();

        BookOuterClass.Book.Builder bookBuilder1 = BookOuterClass.Book.newBuilder();
        bookBuilder1.setName("Book-1")
                .setPrice(11.11)
                .build();

        BookOuterClass.Book.Builder bookBuilder2 = BookOuterClass.Book.newBuilder();
        bookBuilder2.setName("Book-2")
                .setPrice(22.22)
                .build();

        stuBuilder.addListBook(bookBuilder1);
        stuBuilder.addListBook(bookBuilder2);

        stuBuilder.putMapBook("k1", bookBuilder1.build())
                .putMapBook("k2", bookBuilder2.build())
                .build();

    }

    //序列化
   public void test1() throws InvalidProtocolBufferException {
       System.out.println("---------------------- test1 ----------------------");

       Stu.Student student = stuBuilder.build();

       byte[] s = student.toByteArray();
       System.out.println(Arrays.toString(s));
       System.out.println(s.length);

       //转换为json
       String strJson = JsonFormat.printer().includingDefaultValueFields().print(student);
       System.out.println(strJson);

   }

   //反序列化
    public void test2() throws InvalidProtocolBufferException {
        System.out.println("---------------------- test2 ----------------------");
        //先构造出序列化后的数据
        Stu.Student student = stuBuilder.build();
        byte[] s = student.toByteArray();

        Stu.Student stu = Stu.Student.parseFrom(s);
        System.out.println(stu);

        //处理反序列化时中文出现的八进制问题
        System.out.println(TextFormat.printer().escapingNonAscii(false).printToString(stu));
    }

    //pb转json
    public void test3() throws InvalidProtocolBufferException {
        System.out.println("---------------------- test3 ----------------------");
        //先构造出序列化后的数据
        Stu.Student student = stuBuilder.build();

        //转换为json
        String strJson = JsonFormat.printer().includingDefaultValueFields().print(student);
        System.out.println(strJson);

    }

    //json转Pb
    public void test4() throws InvalidProtocolBufferException {
        System.out.println("---------------------- test4 ----------------------");
        //先构造出序列化后的数据
        Stu.Student student = stuBuilder.build();

        //转换为json
        String strJson = JsonFormat.printer().includingDefaultValueFields().print(student);

        //转pb
        Stu.Student.Builder builder = Stu.Student.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(strJson, builder);
        System.out.println(builder.build());
        System.out.println(TextFormat.printer().escapingNonAscii(false).printToString(builder.build()));
    }

    public void test5(){
        System.out.println("---------------------- test5 ----------------------");
        //先构造出序列化后的数据
        Stu.Student student = stuBuilder.build();

        Student student1 = new Student();
        //BeanU

    }
}

public class ProtobufExample2 {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        ProtobufTest protobufTest = new ProtobufTest();
        //protobufTest.test1();
        //protobufTest.test2();
        //protobufTest.test3();
        //protobufTest.test4();
        protobufTest.test5();
    }
}
