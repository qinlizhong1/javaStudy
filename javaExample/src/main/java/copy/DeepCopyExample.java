package copy;

//1.Address1实现Cloneable接口
class Address1 implements Cloneable{
    public String city;

    public Address1(String city) {
        this.city = city;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

//2.School3实现Cloneable接口
class School3 implements Cloneable{
    public int age;
    public Address1 address;

    public School3(int age, Address1 address) {
        this.age = age;
        this.address = address;
    }

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    //重写clone方法，方法中通过super.clone()调用Object类中的原clone方法
    @Override
    public Object clone() throws CloneNotSupportedException {
        School3 school3 = (School3)super.clone();
        school3.setAddress((Address1) school3.getAddress().clone());
        return school3;
    }
}

//深拷贝测试
public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        School3 school = new School3(22, new Address1("北京"));
        School3 otherSchool = (School3)school.clone();

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
