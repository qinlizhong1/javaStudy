package json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student4{
    //Map   name->course
    private Map<String, String> stringMap;
    //List
    private List<String> books;
    // 正常case
    private String name;
    // 空对象case
    private Integer age;
    // 日期转换case
    private Date birthday;
    // 默认值case
    private int weight;
}

public class JackSonExample4 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //在序列化时自定义时间日期格式，不再是默认的时间戳格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //在序列化时忽略值为 null 的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //在序列化时忽略值为默认值的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        //构造数据
        Student4 student4 = new Student4();
        student4.setName("张三丰");
        student4.setBirthday(new Date());

        List<String> books = new ArrayList<>();
        books.add("语文书");
        books.add("数学书");
        student4.setBooks(books);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("张老师", "语文");
        stringMap.put("李老师", "数学");
        student4.setStringMap(stringMap);

        //将构造的Student1对象序列化为json串
        System.out.println("序列化");
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                                        .writeValueAsString(student4);
        System.out.println("json字符串:" + jsonString);

        //将json串反序列化为Student1对象
        System.out.println("\n反序列化");
        Student1 stu = objectMapper.readValue(jsonString, Student1.class);
        System.out.println(stu);

    }
}
