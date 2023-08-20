package common.array;


import java.util.Arrays;

class ArraysExample{
    public void testArraysCopy(){
        System.out.println("\n------------------------   testArraysCopy    -----------------------");
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("arr--->" + Arrays.toString(arr));

        int [] arrCopyOf = Arrays.copyOf(arr, 4);
        System.out.println("copyOf后数组--->" + Arrays.toString(arrCopyOf));

        int [] arrCopyOfRange = Arrays.copyOfRange(arr, 2, 4);//[from, to)半开半闭区间
        System.out.println("copyOfRange后数组--->" + Arrays.toString(arrCopyOfRange));
    }

    public void testArraysSortAndSearch(){
        System.out.println("\n--------------------   testArraysSortAndSearch    -------------------");
        int [] arr = {3, 2, 1, 6, 5, 4, 7, 3, 3};
        System.out.println("原始数组--->" + Arrays.toString(arr));

        Arrays.sort(arr, 2, 5);//局部排序[from, to)半开半闭区间
        System.out.println("sort(arr, 2, 5)后原数组--->" + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("sort(arr)后原数组--->" + Arrays.toString(arr));//整体排序

        int index = Arrays.binarySearch(arr, 3); //全局查找,如有多个，则取最后一个的下标
        System.out.println("binarySearch(arr, 3)--->" + index);

        int indexRange = Arrays.binarySearch(arr, 1, 3, 3); //局部查找
        System.out.println("binarySearch(arr, 1, 3, 3)--->" + indexRange);
    }

    public void testArraysFill(){
        System.out.println("\n------------------------   testArraysFill    ------------------------");
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("原始数组--->" + Arrays.toString(arr));


        Arrays.fill(arr, 6);
        System.out.println("fill(arr, 6)--->" + Arrays.toString(arr));

        Arrays.fill(arr, 2, 5, 8);//[from, to)半开半闭区间
        System.out.println("fill(arr, 2, 5, 8)--->" + Arrays.toString(arr));
    }


    public void testArraysCompare(){
        System.out.println("\n------------------------   testArraysFill    ------------------------");
        int [] arr = {1, 2, 3, 4, 5, 6, 7};

        //rrays.
    }
}

public class ArraysTest {
    public static void main(String[] args) {
        ArraysExample arraysExample = new ArraysExample();
        arraysExample.testArraysCopy();
        arraysExample.testArraysSortAndSearch();
        arraysExample.testArraysFill();
    }
}
