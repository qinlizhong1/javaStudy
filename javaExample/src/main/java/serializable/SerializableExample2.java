package serializable;

import java.io.*;

class Person1 implements Serializable {

    private String name;
    private int age;


    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializableExample1 {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/qin/Desktop/develop/person1.txt");

        // ObjectOutputStream 对象输出流，将Person1存储到person1.txt文件，完成对Person1对象的序列化操作
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Person1 person = new Person1("zhang zhi lin", 28);
        out.writeObject(person);
        out.flush();
        out.close();

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Person1 newPerson = (Person1) in.readObject();
        System.out.println(newPerson);
        in.close();
    }
}
