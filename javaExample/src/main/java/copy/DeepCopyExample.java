package copy;

import com.google.gson.internal.bind.util.ISO8601Utils;

class Address{
    public String city;

    public Address(String city) {
        this.city = city;
    }
}

//1.实现Cloneable接口
class School2 implements Cloneable{
    public int age;
    public Address address;

    public School2(int age, Address address) {
        this.age = age;
        this.address = address;
    }

    //重写clone方法，方法中通过super.clone()调用Object类中的原clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

//引用拷贝测试
public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        School2 school = new School2(11, new Address("北京"));
        School2 otherSchool = (School2)school.clone();

        System.out.println("[1]:" + school);
        System.out.println("[2]:" + otherSchool);

        System.out.println();

        System.out.println("[3]:" + school.address);
        System.out.println("[4]:" + otherSchool.address);

        System.out.println();
        school.age = 66;
        school.address.city = "上海";
        System.out.println("[5]:" + otherSchool.age);
        System.out.println("[6]:" + otherSchool.address.city);
    }
}
