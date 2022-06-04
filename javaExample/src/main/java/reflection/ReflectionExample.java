package reflection;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionTest{
    public void test0() throws ClassNotFoundException {
        System.out.println("----------------------------------------------------------------test0()----------------------------------------------------------------");
        Father father = new Father();
        Class clz1 = father.getClass();
        Class clz2 = Father.class;
        Class clz3 = Class.forName("reflection.Father");

        System.out.println("clz1 == clz2--->" + (clz1 == clz2));
        System.out.println("clz2 == clz3--->" + (clz2 == clz3));
    }

    //获取类属性，设置属性值
    public void test1() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        System.out.println("\n\n----------------------------------------------------------------test1()----------------------------------------------------------------");
        Class clz = Class.forName("reflection.Son");

        Field[] fields = clz.getFields();
        for (Field field : fields){
            System.out.println("1：" + field);
        }

        Field field = clz.getField("fatherPublicVar");
        System.out.println("2：" + field);

        Field[] fieldss = clz.getDeclaredFields();
        for (Field field1 : fieldss){
            System.out.println("3：" + field1);
        }

        Field fieldDeclared = clz.getDeclaredField("sonProtectedVar");
        System.out.println("4：" + fieldDeclared);

        Son son = (Son)clz.newInstance();
        Field fieldFatherPrivateVar = clz.getDeclaredField("sonPrivateVar");
        fieldFatherPrivateVar.setAccessible(true);
        fieldFatherPrivateVar.set(son, 888);
        System.out.println("5：" + son.getSonPrivateVar());
    }

    //获取类方法，调用方法
    public void test2() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("\n\n----------------------------------------------------------------test2()----------------------------------------------------------------");
        Class clz = Class.forName("reflection.Son");

        Method[] methods = clz.getMethods();
        for(Method method : methods){
            System.out.println("1：" + method);
        }

        Method method = clz.getMethod("fatherPublicFun");
        System.out.println("2：" + method);

        Method[] methodss = clz.getDeclaredMethods();
        for(Method method1 : methodss){
            System.out.println("3：" + method1);
        }


    }

    //获取类构造函数，产生类的对象
    public void test3() throws ClassNotFoundException {
        System.out.println("\n\n----------------------------------------------------------------test3()----------------------------------------------------------------");
        Class clz = Class.forName("reflection.Son");


    }
}

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ReflectionTest reflectionTest = new ReflectionTest();
        reflectionTest.test0();
        reflectionTest.test1();
        reflectionTest.test2();
        reflectionTest.test3();
    }
}
