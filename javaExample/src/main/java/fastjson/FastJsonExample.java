package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    @JSONField(ordinal = 1)
    private Integer id;
    @JSONField(ordinal = 2)
    private String name;
    @JSONField(ordinal = 3)
    private Integer age;

    @JSONField(ordinal = 4, format = "yyyy-MM-dd hh:mm:ss")
    private Date bitrthday;
}

/**
 * 对象序列化
 */
class FastJsonTest{
    public void test0(){
        System.out.println("------------------------------------------------------------------test0()------------------------------------------------------------------");
        Student student = new Student(2, "qinlizhong", 30, new Date());
        System.out.println("对象值:");
        System.out.println(student);

        //序列化
        System.out.println("\n序列化结果:");
        String jsongString = JSON.toJSONString(student);
        System.out.println(jsongString);
    }

    /**
     * 集合序列化
     */
    public void test1(){
        System.out.println("\n\n------------------------------------------------------------------test1()------------------------------------------------------------------");
        Student student1 = new Student(2, "qinlizhong", 30, new Date());
        Student student2 = new Student(1, "张三", 38, new Date());

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        System.out.println("集合值:");

        for (Student student : students){
            System.out.println(student);
        }

        //序列化
        System.out.println("\n序列化结果:");
        String jsongString = JSON.toJSONString(students);
        System.out.println(jsongString);
    }

    /**
     * map序列化
     */
    public void test2(){
        System.out.println("\n\n------------------------------------------------------------------test2()------------------------------------------------------------------");
        Student student1 = new Student(2, "qinlizhong", 30, new Date());
        Student student2 = new Student(1, "张三", 38, new Date());

        Map<String, Student> students = new HashMap<>();
        students.put("stu1", student1);
        students.put("stu2", student2);
        System.out.println("map值:");
        Set<Map.Entry<String, Student>> entries = students.entrySet();
        for (Map.Entry<String, Student> entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //序列化
        System.out.println("\n序列化结果:");
        String jsongString = JSON.toJSONString(students);
        System.out.println(jsongString);
    }

    /**
     *  json反序列化为java对象
     */
    public void test3(){
        System.out.println("\n\n------------------------------------------------------------------test3()------------------------------------------------------------------");
        String strJson = "{\"age\":11,\"bitrthday\":1620137932283,\"id\":1,\"name\":\"qinlizhong\"}";
        System.out.println("json值:");
        System.out.println(strJson);

        Student student = JSON.parseObject(strJson, Student.class);
        System.out.println("\n反序列化结果:");
        System.out.println(student);
    }

    /**
     *  json反序列化为java集合
     */
    public void test4(){
        System.out.println("\n\n------------------------------------------------------------------test4()------------------------------------------------------------------");
        String strJson = "[{\"age\":11,\"bitrthday\":1620138289599,\"id\":1,\"name\":\"list\"},{\"age\":12,\"bitrthday\":1620138289599,\"id\":2,\"name\":\"lisa\"}]";
        System.out.println("json值:");
        System.out.println(strJson);

        List<Student> students = JSON.parseArray(strJson, Student.class);
        System.out.println("\n反序列化结果:");
        for (Student student : students){
            System.out.println(student);
        }
    }

    /**
     * json反序列化为map
     */
    public void test5(){
        System.out.println("\n\n------------------------------------------------------------------test5()------------------------------------------------------------------");
        String strJson = "{\"stu2\":{\"age\":12,\"bitrthday\":1620138549606,\"id\":2,\"name\":\"lisa\"},\"stu1\":{\"age\":11,\"bitrthday\":1620138549606,\"id\":1,\"name\":\"list\"}}";
        System.out.println("json值:");
        System.out.println(strJson);

        Map<String, Student> students = JSON.parseObject(strJson, new TypeReference<Map<String, Student>>(){});
        System.out.println("\n反序列化结果:");
        Set<Map.Entry<String, Student>> entries = students.entrySet();
        for (Map.Entry<String, Student> entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

public class FastJsonExample {
    public static void main(String[] args) {
        FastJsonTest fastJsonTest = new FastJsonTest();
        fastJsonTest.test0();
        fastJsonTest.test1();
        fastJsonTest.test2();
        fastJsonTest.test3();
        fastJsonTest.test4();
        fastJsonTest.test5();
    }
}
