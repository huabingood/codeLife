package kafka.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerTest {

    public static void main(String[] args){
        Properties props = new Properties();
        // bootstrap.servers设置要连接的Broker，多个可以使用逗号隔开。
        props.put("bootstrap.servers", "huabingood01:9092");
        props.put("group.id", "test");
        // 设置enable.auto.commit为true开启自动提交offset，自动提交的频率由 auto.commit.interval.ms 设置。
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        // deserializer 用于序列化 key 和 value
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        // 创建一个消费者对象。KafkaConsumer的第一个泛型是offset，第二个泛型是message
        KafkaConsumer<String,String> consumer  = new KafkaConsumer<String, String>(props);
        // consumer.subscribe 决定该consumer订阅哪些主题。一个consumer可以订阅多个主题
        consumer.subscribe(Arrays.asList("google"));

        while(true){
            // 后面的好像是如果数据失败，等待多少秒
            ConsumerRecords<String,String> records = consumer.poll(1000);
            for(ConsumerRecord record:records){
                System.out.println("offset:"+record.offset()+"key"+record.key()+"value"+record.value());
            }
        }

    }

}
