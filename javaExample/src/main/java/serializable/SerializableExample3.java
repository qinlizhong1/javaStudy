package serializable;

import java.io.*;

class Person3 implements Serializable {

    private String name;
    private static int age = 66;

    public Person3(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person3(String name) {
        this.name = name;
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

public class SerializableExample3 {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/qin/Desktop/develop/person1.txt");

        // ObjectOutputStream 对象输出流，将Person1存储到person1.txt文件，完成对Person1对象的序列化操作
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Person3 person = new Person3("liu de hua");
        out.writeObject(person);
        out.flush();
        out.close();

        //在反序列化出来之前，改变静态变量的值
        person.setAge(99);

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Person3 newPerson = (Person3) in.readObject();
        System.out.println(newPerson);
        in.close();
    }
}
