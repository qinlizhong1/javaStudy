package arrays;

public class ArrayDemo {
    public static void main(String args[]) {
        int data[] = null;
        data = new int[3]; //开辟一个长度为3的数组
        int temp[] = null; //声明对象
        data[0] = 10;
        data[1] = 20;
        data[2] = 30;
        temp = data;  //int temp[] = data;
        temp[0] = 99;
        for(int i = 0; i < temp.length; i++) {
            System.out.println(data[i]);
        }
    }
}