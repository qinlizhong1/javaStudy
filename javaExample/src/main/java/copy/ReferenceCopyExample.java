package copy;

class School1{
    public String name;
    public String address;

    public School1(String name, String address) {
        this.name = name;
        this.address = address;
    }

}

//引用拷贝测试
public class ReferenceCopyExample {
    public static void main(String[] args) {
        School1 school = new School1("北京大学", "北京");
        School1 otherSchool = school;

        System.out.println("[1]:" + school);
        System.out.println("[2]:" + otherSchool);
    }
}
