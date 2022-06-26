package thread.threadsafe;

class Singleton {
    private static  Singleton singleton;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

public class UnSafeSingletonExample {
    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                Singleton singleton1 = Singleton.getInstance();
            }).start();

            new Thread(()->{
                Singleton singleton2 = Singleton.getInstance();
            }).start();
        }
    }
}
