package arrays;

import java.util.Arrays;

class ArraysTest{
    public void test0(){
        int arr[] = new int[]{6,5,3,4,2,1,7,8};

        int[] arrCopyOf = Arrays.copyOf(arr, 15);
        int[] arrCopyOfRange = Arrays.copyOfRange(arr, 2, 6);
        System.out.println("【1】arrCopyOf--->" + Arrays.toString(arrCopyOf));
        System.out.println("【2】arrCopyOfRange--->" + Arrays.toString(arrCopyOfRange));

        Arrays.sort(arr);
        System.out.println("【3】after sort arr--->" + Arrays.toString(arr));

        int target = Arrays.binarySearch(arr, 5);
        System.out.println("【4】5在排序后的数组的下标为--->" + target);

        Arrays.fill(arr, 8);
        System.out.println("【5】after fill arr--->" + Arrays.toString(arr));

        Arrays.fill(arr, 3, 5, 6);
        System.out.println("【6】after fill arr--->" + Arrays.toString(arr));
    }
}

public class ArraysExample {
    public static void main(String[] args) {
        ArraysTest arraysTest = new ArraysTest();
        arraysTest.test0();
    }
}
