package innerclass;

class Outer2 {
    private static int x = 11;
    private int y = 1;
    static class StaticInner{
        private int x = 22;

        public void InnerFun() {
            System.out.println("成员内部类的x变量:" + x);
            //访问同名的外部成员  外部类名.同名成员名
            System.out.println("外部类的x变量:" + Outer2.x);

            //编译报错：不能访问外部类的非静态成员
            //System.out.println("外部类的x变量:" + y);
        }
    }

    public StaticInner getInnerClassInstance(){
        return new StaticInner();
    }
}

public class StaticInnerClassExample {
    public static void main(String[] args) {
        Outer2.StaticInner staticInner = new Outer2.StaticInner();
        staticInner.InnerFun();

        System.out.println();
        Outer2 outer2 = new Outer2();
        outer2.getInnerClassInstance().InnerFun();
    }
}
