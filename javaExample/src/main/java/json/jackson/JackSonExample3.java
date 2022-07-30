package json.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student3{
    @JsonProperty("string_map")
    private Map<String, String> stringMap;
    @JsonIgnore
    private List<String> books;
    private String name;
    private Integer age;

    @JsonFormat(timezone = "GMT+8", pattern = "yy-MM-dd HH:mm:ss")
    private Date birthday;
    private int weight;
}

public class JackSonExample3 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //构造数据
        Student3 student3 = new Student3();
        student3.setName("张三丰");
        student3.setBirthday(new Date());


        List<String> books = new ArrayList<>();
        books.add("语文书");
        books.add("数学书");
        student3.setBooks(books);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("张老师", "语文");
        stringMap.put("李老师", "数学");
        student3.setStringMap(stringMap);

        //将构造的Student1对象序列化为json串
        System.out.println("序列化");
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                                        .writeValueAsString(student3);
        System.out.println("json字符串:");
        System.out.println(jsonString);

        /*
        //将json串反序列化为Student1对象
        System.out.println("\n反序列化");
        Student1 stu = objectMapper.readValue(jsonString, Student1.class);
        System.out.println(stu);
        */
    }
}
