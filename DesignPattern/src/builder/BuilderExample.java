package builder;

class Employee{
    private String name;
    private int age;
    private String sex; //性别，可选
    private String country; //国家，可选

    //在Employee中创建一个private的构造函数，参数为Builder类型
    private Employee(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.country = builder.country;
    }

    //2.在Employee创建静态内部类Builder，将Employee的成员变量复制到Builder类中
    public static class Builder{
        private String name;
        private int age;
        private String sex; //性别，可选
        private String country; //国家，可选

        //3.在Builder中创建一个public的构造函数，参数为必填的那些参数，name 和age。
        public Builder(String name, int age){
            this.name = name;
            this.age = age;
        }

        //4.在Builder中创建设置函数，对那些可选参数进行赋值，返回值为Builder类型的实例
        public Builder setSex(String sex){
            this.sex = sex;
            return this;
        }
        public Builder setCountry(String country){
            this.country = country;
            return this;
        }

        //在Builder中创建一个build()方法，在其中构建Employee的实例并返回
        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        //使用建造者模式将对象一步步创建出来
        Employee employee = new Employee.Builder("李世民", 55)
                                        .setSex("男")
                                        .setCountry("唐朝")
                                        .build();

        System.out.println(employee);
    }
}
