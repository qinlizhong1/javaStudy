package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collections;

public class KafkaConsumerDemo {
    /**
     *接受String类型数据
     */
    public static void syncReceiveString(){
        KafkaConsumer<String, String> kafkaConsumer = new KafkaUtils().getDefaultKafkaConsumer();

        //kafkaConsumer.subscribe(Collections.singleton(KafkaUtils.TOPIC));
        kafkaConsumer.assign(Arrays.asList(new TopicPartition(KafkaUtils.TOPIC, 0)));
        kafkaConsumer.seekToBeginning(Arrays.asList(new TopicPartition(KafkaUtils.TOPIC, 0)));
        while (Boolean.TRUE){
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(1000);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords){
                System.out.println("Consumer offset:" + consumerRecord.offset() + " , value:" + consumerRecord.value());
            }

        }
    }

    public static void main(String[] args) {
        KafkaConsumerDemo.syncReceiveString();
    }
}
