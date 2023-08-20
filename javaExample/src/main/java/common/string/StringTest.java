package common.string;

import java.util.Arrays;

/**
 * 1:String类型对象是不可变的
 */
class StringExample{
    public void testStringFind(){
        System.out.println("\n------------------------   testStringFind    ------------------------");

        String s = "0123454321";
        System.out.println("s--->" + s);
        System.out.println("s.isEmpty()--->" + s.isEmpty());
        System.out.println("s.charAt(1)--->" + s.charAt(1));
        System.out.println("s.length()--->" + s.length());
        System.out.println("s.length(\"54\")--->" + s.contains("54"));

        System.out.println("\ns.indexOf(\"3\")--->" + s.indexOf("3"));
        System.out.println("s.indexOf(\"3\", 4)--->" + s.indexOf("3", 4));
        System.out.println("\ns.lastIndexOf(\"3\")--->" + s.lastIndexOf("3"));
        System.out.println("s.lastIndexOf(\"3\", 6)--->" + s.lastIndexOf("3", 6));//从fromIndex位置处往起始位置找

        System.out.println("\ns.startsWith(\"012\")--->" + s.startsWith("012"));
        System.out.println("s.startsWith(\"454\", 4)--->" + s.startsWith("454", 4));

        System.out.println("\ns.endsWith(\"321\")--->" + s.endsWith("321"));
    }


    public void testStringTrans() {
        System.out.println("\n------------------------   testStringCharTrans    ------------------------");
        String s = "    abcdABCD 12&  ";
        System.out.println("s--->" + s);
        System.out.println("s.toUpperCase()--->" + s.toUpperCase());//英文字符转换，其它字符不变
        System.out.println("s.toLowerCase()--->" + s.toLowerCase());//英文字符转换，其它字符不变
        System.out.println("s.trim()--->" + s.trim()); //去掉首尾空白字符
    }


    public void testString1() {
        System.out.println("\n------------------------   testStringCharTrans    ------------------------");
        String s = "aa&bb&cc&dd";
        System.out.println("s--->" + s);
        System.out.println("s.substring(2)--->" + s.substring(2));
        System.out.println("s.substring(2, 5)--->" + s.substring(2, 5)); //[from, to)半开半闭区间
        System.out.println("s.concat(\"6688\")--->" + s.concat("6688"));
        System.out.println();

        String[] strArray = s.split("&", 2);//第二个参数表示切割成几部分
        for (String str : strArray) {
            System.out.println(str);
        }
    }
}

public class StringTest {
    public static void main(String[] args) {
        StringExample stringExample = new StringExample();
        stringExample.testStringFind();
        stringExample.testStringTrans();
        stringExample.testString1();
    }
}
