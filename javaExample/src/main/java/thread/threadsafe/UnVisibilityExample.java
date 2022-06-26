package thread.threadsafe;

class UnVisibilityTest{
    int a = 10;
    int b = 20;

    private void change() {
        a = 30;
        b = a;
    }

    private void show() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public void testUnVisibility(){
        while (true){
            UnVisibilityTest unVisibilityTest = new UnVisibilityTest();

            //修改线程
            new Thread(() -> {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unVisibilityTest.change();
            }).start();

            //读取线程
            new Thread(() -> {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unVisibilityTest.show();
            }).start();
        }
    }

}

//线程不可见性测试
public class UnVisibilityExample {
    public static void main(String[] args) {
        UnVisibilityTest unVisibilityTest = new UnVisibilityTest();
        unVisibilityTest.testUnVisibility();
    }
}
