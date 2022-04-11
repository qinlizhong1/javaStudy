package collection;

import java.util.Arrays;

class ArrayTest{
    public void test0(){
        System.out.println("---------------------------------------test0()---------------------------------------");
        int []arr = new int[]{4, 3, 1, 2, 5};
        System.out.println("Arrays.toString(arr)--->"+ Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Arrays.toString(arr)--->"+ Arrays.toString(arr));

        System.out.println("Arrays.binarySearch(arr, 4)--->"+ Arrays.binarySearch(arr, 4));
        System.out.println("Arrays.binarySearch(arr, 6)--->"+ Arrays.binarySearch(arr, 6));
    }

    public void test1() {
        System.out.println("\n\n---------------------------------------test1()---------------------------------------");
        int []arr = new int[]{4, 3, 1, 2, 5};
        System.out.println("Arrays.toString(arr)--->"+ Arrays.toString(arr));

        int []arrCopyOf = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.toString(arrCopyOf)--->"+ Arrays.toString(arrCopyOf));

        int []arrCopyOfRange = Arrays.copyOfRange(arr, 0, 3);
        System.out.println("Arrays.toString(arrCopyOfRange)--->"+ Arrays.toString(arrCopyOfRange));
    }

    public void test2() {
        System.out.println("\n\n---------------------------------------test2()---------------------------------------");
        int []arr = new int[5];
        Arrays.fill(arr, 10);
        System.out.println("Arrays.toString(arr)--->"+ Arrays.toString(arr));

        Arrays.fill(arr, 2, 4, 5);
        System.out.println("Arrays.toString(arr)--->"+ Arrays.toString(arr));
    }
}

public class ArrayExample {
    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.test0();
        arrayTest.test1();
        arrayTest.test2();
    }
}
