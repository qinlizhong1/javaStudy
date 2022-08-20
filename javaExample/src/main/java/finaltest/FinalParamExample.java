package finaltest;

public class FinalParamExample {
    public void show(final int param) {

        //编译报错：Cannot assign a value to final variable 'param'
        //param=10;
        System.out.println(param);
    }

    public static void main(String[] args) {
        FinalParamExample finalParamExample = new FinalParamExample();
        finalParamExample.show(5);
    }
}
