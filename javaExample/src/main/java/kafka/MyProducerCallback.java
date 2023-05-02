package kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (null != e) {
            System.out.println("Producer生产消息异常：" + e);
        }

        if (null != recordMetadata) {
            System.out.println("Producer生产消息：metadata：" + recordMetadata +
                    "partition:" + recordMetadata.partition() + "offset:" + recordMetadata.offset());
        }
    }
}
