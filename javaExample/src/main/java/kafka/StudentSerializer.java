package kafka;

import org.apache.kafka.common.serialization.Serializer;
import com.alibaba.fastjson.JSON;

public class StudentSerializer implements Serializer<Student>
{

    @Override
    public byte[] serialize(String topic, Student data) {
        return JSON.toJSONBytes(data);
    }

}
