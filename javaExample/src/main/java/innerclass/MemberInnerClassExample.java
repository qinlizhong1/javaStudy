package innerclass;

class Outer1{
    private int x = 11;
    class MemberInner{
        private int x = 22;
        public void InnerFun(){
            System.out.println("成员内部类的x变量:" + x);
            //访问同名的外部成员外部类名.this.同名成员名
            System.out.println("外部类的x变量:" + Outer1.this.x);
        }
    }

    public MemberInner getInnerClassInstance(){
        return new MemberInner();
    }
}


public class MemberInnerClassExample {
    public static void main(String[] args) {
        //使用成员内部类方式1
        Outer1 outer1 = new Outer1();
        Outer1.MemberInner memberInner1 = outer1.new MemberInner();
        memberInner1.InnerFun();

        System.out.println();

        //使用成员内部类方式2
        Outer1.MemberInner memberInner2 = outer1.getInnerClassInstance();
        memberInner1.InnerFun();
    }
}
