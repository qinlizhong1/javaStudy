package finaltest;

import java.util.Arrays;

class FinalReferencVarTest{
    final int arr0[] = {1, 2, 3};
    final int arr1[] = {4, 5, 6};

    /*
    //编译报错
    public void test0(){
        arr0 = arr1;
    }
    */

    public void test1(){
        for (int i = 0; i < arr0.length; i++) {
            arr0[i] = arr0[i]*10;
        }

        System.out.println("arr0:" + Arrays.toString(arr0));
    }
}

public class FinalReferencVarExample {
    public static void main(String[] args) {
        FinalReferencVarTest finalMemberVarTest = new FinalReferencVarTest();
        //finalMemberVarTest.test0();
        finalMemberVarTest.test1();
    }
}
