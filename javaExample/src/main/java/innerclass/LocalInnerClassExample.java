package innerclass;

class Outer3 {
    String name = "大大";
    public static int age = 22;

    public Object getHeart(){
        //方法内部类：不能使用任何访问修饰符，不能使用static修饰
        class LocalInner {
            String name = "小小";
            //类成员可以使用访问修饰符、final，但不能使用static修饰
            public final int age = 12;

            public String beat(){
                //访问外部类的成员
                new Outer3().eat();
                return name + Outer3.age + "的心脏在跳动";
            }
        }
        return new LocalInner().beat();
    }
    public void eat(){
        System.out.println("人会吃东西");
    }
}

public class LocalInnerClassExample {
    public static void main(String[] args) {
        Outer3 outer3 = new Outer3();
        //调用包含局部内部类的方法
        System.out.println(outer3.getHeart());
    }
}
