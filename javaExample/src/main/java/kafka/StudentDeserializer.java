package kafka;
import org.apache.kafka.common.serialization.Deserializer;

import com.alibaba.fastjson.JSON;
public class StudentDeserializer implements Deserializer<Student>{
    @Override
    public Student deserialize(String topic, byte[] data) {

        return JSON.parseObject(data, Student.class);
    }

}
