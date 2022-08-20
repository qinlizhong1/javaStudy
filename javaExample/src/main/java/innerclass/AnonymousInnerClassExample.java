package innerclass;


public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        //匿名内部类(相当于定义了一个重写了run方法的hread子类实例)
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("I am thread:" + Thread.currentThread().getName());
            }
        };

        thread.start();
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}
