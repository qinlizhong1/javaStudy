package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;


public class KafkaProductDemo {
    /**
     * 同步发送String类型数据
     */
    public static void syncSendString() throws ExecutionException, InterruptedException {
        KafkaProducer<String, String> kafkaProducer = new KafkaUtils().getDefaultKafkaProducer();

        //3. 创建消息；key：作用是决定了往哪个分区上发，value：具体要发送的消息内容
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>( KafkaUtils.TOPIC,"qin-key", "qin-val");


        //4. 发送消息，得到消息发送的元数据并输出
        RecordMetadata metadata = kafkaProducer.send(producerRecord).get();
        System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                + metadata.partition() + "|offset-" + metadata.offset()) ;

    }

    /**
     * 同步发送自定义类型数据
     * 关键其实就是序列化，我们使用FastJson来序列化要发送的自定义对象。
     * 1：定义要发送的对象Student    2:定义序列化StudentSerializer实现Serializer接口
     * 3：设置value序列化方式为自定义的StudentSerializer全类名
     */
    public static void syncSendObj() throws ExecutionException, InterruptedException {
        KafkaProducer<String, Student> kafkaProducer = new KafkaUtils("org.apache.kafka.common.serialization.StringSerializer", "kafka.StudentSerializer")
                .getStudentKafkaProducer();

        //3. 创建消息；key：作用是决定了往哪个分区上发，value：具体要发送的消息内容
        Student student = new Student(1, "qinli", 28);
        ProducerRecord<String, Student> producerRecord = new ProducerRecord<>( KafkaUtils.TOPIC,"qin-key", student);



        //4. 发送消息，得到消息发送的元数据并输出
        RecordMetadata metadata = kafkaProducer.send(producerRecord).get();
        System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                + metadata.partition() + "|offset-" + metadata.offset()) ;

    }


    /**
     * 异步发送自定义类型数据
     */
    public static void asyncSendObj() throws ExecutionException, InterruptedException {
        KafkaProducer<String, Student> kafkaProducer = new KafkaUtils("org.apache.kafka.common.serialization.StringSerializer", "kafka.StudentSerializer")
                .getStudentKafkaProducer();

        //3. 创建消息；key：作用是决定了往哪个分区上发，value：具体要发送的消息内容
        Student student = new Student(2, "张智霖", 16);
        ProducerRecord<String, Student> producerRecord = new ProducerRecord<>( KafkaUtils.TOPIC,"zhang-key", student);


        //4. 发送消息，得到消息发送的元数据并输出
        kafkaProducer.send(producerRecord, new MyProducerCallback()).get();
        //System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
          //      + metadata.partition() + "|offset-" + metadata.offset()) ;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KafkaProductDemo.syncSendString();
        //KafkaProduct.syncSendObj();
        //KafkaProductDemo.asyncSendObj();
    }
}
