package json.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    private String sex;
    private Integer age;

    private Date birthday;
}
public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonStrStu = "{\"name\":\"包青天\",\"sex\":\"男\"," +
                "\"age\":35,\"k1\":\"v1\",\"k2\":\"v2\"}";


        ObjectMapper objectMapper = new ObjectMapper();
        Student2 stu = objectMapper.readValue(jsonStrStu, Student2.class);

        System.out.println(stu);
    }
}

/* JsonAnySetter示例
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    private String sex;
    private Integer age;

    @JsonAnySetter
    private Map<String,String> map = new HashMap<>();
    /*也可以用在这个方法上
    @JsonAnySetter
    public void putMap(String key, String value) {
        map.put(key,value);
    }
    //
}
public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonStrStu = "{\"name\":\"包青天\",\"sex\":\"男\"," +
                "\"age\":35,\"k1\":\"v1\",\"k2\":\"v2\"}";


        ObjectMapper objectMapper = new ObjectMapper();
        Student2 stu = objectMapper.readValue(jsonStrStu, Student2.class);

        System.out.println(stu);
    }
}
*/

/*  @JsonAnyGetter示例
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    private String sex;
    private Integer age;

    private Map<String,String> map = new HashMap<>();
    @JsonAnyGetter
    public Map<String,String> getMapTest() {
        return map;
    }
}
public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2();
        stu.setName("包青天");
        stu.setSex("男");
        stu.setAge(38);

        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        stu.setMap(map);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStrStu);
    }
}
*/

/*  @JsonRawValue示例
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    private String sex;
    private Integer age;
    @JsonRawValue
    private String address;

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        String address = "{\"city\":\"四川\", \"street\":\"玉林小接\"}";
        Student2 stu = new Student2("张飞", "男", 38, address);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);
        String jsonStrAddress = objectMapper.writeValueAsString(address);

        System.out.println(jsonStrStu);
    }
}
*/

/*  @JsonAutoDetect示例
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Student2{
    private String name;
    private String sex;
    private Integer age;

    public Student2(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("包青天", "55", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStrStu);
    }
}
*/

/*  @JsonCreator示例
@Data
class Student2{
    private String name;
    private String sex;
    private Integer age;

    @JsonCreator
    public Student2(@JsonProperty("name") String name, @JsonProperty("sex") String sex,
                    @JsonProperty("age") Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        System.out.println("反序列化调用了有参构造函数");
    }
}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonStrStu = "{\"name\":\"包青天\", \"sex\":\"男\", \"age\":66}";

        ObjectMapper objectMapper = new ObjectMapper();
        Student2 stu = objectMapper.readValue(jsonStrStu, Student2.class);

        System.out.println(stu);
    }
}
*/

/*  @JsonProperty示例
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    @JsonProperty("fullName")
    private String name;
    private String sex;
    private Integer age;

    public String showJson(){
        return name + ", " + sex + ", " + age;
    }

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("包青天", "55", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStrStu);
    }
}
*/

/*  @JsonValue示例
@Data
@AllArgsConstructor
@NoArgsConstructor

class Student2{
    private String name;
    private String sex;
    private Integer age;

    @JsonValue
    public String showJson(){
        return name + ", " + sex + ", " + age;
    }

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("包青天", "55", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStrStu);
    }
}

*/
/*  @JsonPropertyOrder示例
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"sex", "age"})
class Student2{
    private String name;
    private String sex;
    private Integer age;

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("包青天", "55", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStrStu);
    }
}
*/

/*  @JsonIgnoreType示例
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
class Address{
    private String city;
    private String street;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    private String sex;
    private Integer age;
    private Address address;

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Address address = new Address("四川", "玉林小街");
        Student2 stu = new Student2("张飞", "男", 38, address);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrStu = objectMapper.writeValueAsString(stu);
        String jsonStrAddress = objectMapper.writeValueAsString(address);
        System.out.println("address--->" + jsonStrAddress);

        System.out.println("stu--->" +jsonStrStu);
    }
}
*/
/*   @JsonIgnoreProperties示例
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"name", "age"})
class Student2{
    private String name;
    private String sex;
    private Integer age;

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("张飞", "男", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStr);
    }
}
*/

/*   @JsonIgnore示例
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    private String name;
    @JsonIgnore
    private String sex;
    private Integer age;

}

public class JackSonExample2 {
    public static void main(String[] args) throws JsonProcessingException {
        Student2 stu = new Student2("张飞", "男", 38);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(stu);

        System.out.println(jsonStr);
    }
}
*/