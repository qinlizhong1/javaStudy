package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(includes = {"name", "bitrthday"}, orders = {"bitrthday", "name"}, serialzeFeatures = {SerializerFeature.WriteClassName})
class Teacher {
    private Integer id;

    private String name;

    private Integer age;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date bitrthday;
}

class JSONTypeTest {
    public void test0() {
        System.out.println("------------------------------------------------------------------test0()------------------------------------------------------------------");
        Teacher teacher = new Teacher(2, "qinlizhong", 30, new Date());
        System.out.println("对象值:");
        System.out.println(teacher);

        //序列化
        System.out.println("\n序列化结果:");
        String jsongString = JSON.toJSONString(teacher);
        System.out.println(jsongString);
    }
}

public class JSONTypeExample {
    public static void main(String[] args) {
        JSONTypeTest jsonTypeTest = new JSONTypeTest();
        jsonTypeTest.test0();
    }
}
