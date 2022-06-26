package thread.threadsafe;

class MyRunnable implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        for (int i=0; i<10000; i++){
            ++count;
        }
    }

    public int getCount() {
        return count;
    }
}

class ThreadUnSafeTest{
    public void testUnSafeThread() throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Thread t1;
        Thread t2;

        t1 = new Thread(runnable);
        t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("count:" + runnable.getCount());
    }
}

public class ThreadUnSafeExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadUnSafeTest threadUnSafeTest = new ThreadUnSafeTest();
        threadUnSafeTest.testUnSafeThread();
    }
}
