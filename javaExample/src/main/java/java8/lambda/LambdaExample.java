package java8.lambda;

public class LambdaExample {
    public static void main(String[] args) {
        //普通写法(匿名内部类)
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ordinary Writing");
            }
        });
        thread.start();

        //Lambda写法。无参无返回void
        Thread thread1 = new Thread(() -> System.out.println("Lambda Writing"));
        thread1.start();
    }
}
