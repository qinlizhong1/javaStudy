package a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Cat implements Serializable{
    String name;
    Integer age;


}

class FileExample{
    public void test1() throws IOException {
        String filePath = "/Users/qin/data/mytemp";
        File file = new File(filePath);

        if (!file.exists()){
            System.out.println("文件不存在，现在创建");
            file.createNewFile();
        }else {
            System.out.println("文件已经存在");
        }
    }

    public void test2() throws IOException {
        String filePath = "/Users/qin/data";
        String fileName = "mytemp1";
        File file = new File(filePath, fileName);

        if (!file.exists()){
            System.out.println("文件不存在，现在创建");
            file.createNewFile();
        }else {
            System.out.println("文件已经存在");
        }
    }

    public void test3() throws IOException {
        String filePath = "/Users/qin/data";
        String fileName = "mytemp2";
        File file = new File(new File(filePath), fileName);

        if (!file.exists()){
            System.out.println("文件不存在，现在创建");
            file.createNewFile();
        }else {
            System.out.println("文件已经存在");
        }
    }

    public void test4() throws IOException {
        String filePath = "/Users/qin/data/test.txt";
        File file = new File(filePath);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        int i = 1;
        while((line = bufferedReader.readLine()) != null){
            System.out.println("第 " + i + " 行:" + line);
        }

        bufferedReader.close();
    }

    public void test5() throws IOException {
        String filePath = "/Users/qin/data/test.txt1";
        File file = new File(filePath);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        String line = null;
        int i = 1;
        bufferedWriter.write("a");
        bufferedWriter.newLine();
        bufferedWriter.write("b");
        bufferedWriter.close();
    }

    public void test6() throws IOException {
        String filePath = "/Users/qin/data/test6";
        File file = new File(filePath);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        Cat cat = new Cat();
        cat.setName("aaa");
        cat.setAge(12);

        objectOutputStream.writeObject(cat);
    }

    public void test7() throws IOException, ClassNotFoundException {
        String filePath = "/Users/qin/data/test6";
        File file = new File(filePath);


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

        Cat cat = (Cat) objectInputStream.readObject();

        System.out.println(cat);
    }

}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileExample fileExample = new FileExample();
        fileExample.test7();
    }
}
