package kafka;

import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Collection;
import java.util.Properties;

@Data
public class KafkaUtils {
    //TOPIC
    public static final String TOPIC = "my-topic";
    //Kafka主机
    private String kafkaHost = "127.0.0.1:9092, 127.0.0.1:9093, 127.0.0.1:9094";


    //ack=0:kafka-cluster不需要任何的broker收到消息，就立即返回ack给生产者，最容易丢消息，但是效率是最高的
    //ack=1（默认）：多副本之间的leader已经收到消息，并把消息写入到本地log中，才会返回ack给生产者，性能和安全是最均衡的。
    //ack=-1/all。里面有默认的配置min.insync.replicas=2(默认为1，推荐配置大于等于2)，此时就需要leader和一个follower同步完成之后，才会返回ack给生产者（此时集群中有2个broker已完成数据的接收），这种方式最安全，但性能最差。
    private String ack = "all";

    //如果没有收到ack，就重试,这个参数是生产者重试次数
    //重试能保证消息发送的可靠性，但是也可能造成消息重复发送，比如：网络抖动，所以需要在接收者那边做好消息接收的幂等性处理
    private Integer retryTimes = 1;

    //生产者：向同一分区发送打包发送的数据量，单位：bytes，默认16384bytes=16K
    private Integer batchSize = 16384;

    //生产者：批量发送消息的间隔时间（延迟时间），单位：毫秒
    private Integer lingerMs = 1;

    //生产者：可以使用的最大缓存空间，单位：bytes，默认33554432bytes=32M.
    private Integer bufferMemory = 33554432;

    //生产者：键编码器
    private String keyEncoder = "org.apache.kafka.common.serialization.StringSerializer";

    //生产者：值编码器
    private String valueEncoder = "org.apache.kafka.common.serialization.StringSerializer";

    //消费者：消费topic的组ID
    private String groupId = "my-group-id";

    //消费者：后台定期提交offset
    private String autoCommit = "true";


    //消费者提交offset的时间间隔：单位：毫秒，当enable.auto.commit为true时生效
    private String autoCommitIntervalMs = "1000";

    //消费者：键解码器
    private String keyDecoder = "org.apache.kafka.common.serialization.StringDeserializer";

    //消费者：值解码器
    private String valueDecoder = "org.apache.kafka.common.serialization.StringDeserializer";

    //消费者：重启后配置offset, latest：消费者从最新的offset开始消费
    private String autoOffsetReset = "latest";

    public KafkaUtils(){

    }

    public KafkaUtils(String keyEncoder, String valueEncoder){
        this.keyEncoder = keyEncoder;
        this.valueEncoder = valueEncoder;
    }

    public KafkaUtils(String kafkaHost, String ack, Integer retryTimes, Integer batchSize, Integer lingerMs, Integer bufferMemory, String keyEncoder, String valueEncoder, String groupId, String autoCommit, String autoCommitIntervalMs, String keyDecoder, String valueDecoder, String autoOffsetReset, Collection<String> topic) {
        this.kafkaHost = kafkaHost;
        this.ack = ack;
        this.retryTimes = retryTimes;
        this.batchSize = batchSize;
        this.lingerMs = lingerMs;
        this.bufferMemory = bufferMemory;
        this.keyEncoder = keyEncoder;
        this.valueEncoder = valueEncoder;
        this.groupId = groupId;
        this.autoCommit = autoCommit;
        this.autoCommitIntervalMs = autoCommitIntervalMs;
        this.keyDecoder = keyDecoder;
        this.valueDecoder = valueDecoder;
        this.autoOffsetReset = autoOffsetReset;
        //this.topic = TOPIC;
    }

    /**
     *创建生产消息的客户端，传入参数
     */
    public  KafkaProducer<String, String> getDefaultKafkaProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
        properties.put(ProducerConfig.ACKS_CONFIG, ack);
        properties.put(ProducerConfig.RETRIES_CONFIG, retryTimes);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keyEncoder);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueEncoder);
        return new KafkaProducer<>(properties);
    }

    /**
     *创建生产消息的客户端，传入参数
     */
    public  KafkaProducer<String, Student> getStudentKafkaProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
        properties.put(ProducerConfig.ACKS_CONFIG, ack);
        properties.put(ProducerConfig.RETRIES_CONFIG, retryTimes);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keyEncoder);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueEncoder);
        return new KafkaProducer<>(properties);
    }

}
