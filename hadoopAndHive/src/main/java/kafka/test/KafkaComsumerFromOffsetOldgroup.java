package kafka.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 从指定位置开始读取数据
 * 可以是原来的组
 * 但是：
 * consumer.assign()是不会被消费者的组管理功能管理的，他相对于是一个临时的，不会改变当前group.id的offset
 */
public class KafkaComsumerFromOffsetOldgroup {
    public static final  String TOPIC="google";


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

        // 这里是从指定位置开始读取数据的代码开始
        // assign只是告诉系统共有几个分区
        List partitonsAndoffset = new ArrayList();
        partitonsAndoffset.add(new TopicPartition(TOPIC,0));
        partitonsAndoffset.add(new TopicPartition(TOPIC,1));
        consumer.assign(partitonsAndoffset);
        // seek表示从分区的什么地方来获取数据，第二个参数表示从该分区的offset开始读取，这个参数可以指定
        consumer.seek(new TopicPartition(TOPIC,0),2);
        consumer.seek(new TopicPartition(TOPIC,1),0);




        while(true){
            // 后面的好像是如果数据失败，等待多少秒
            ConsumerRecords<String,String> records = consumer.poll(1000);
            for(ConsumerRecord record:records){
                System.out.println("offset:"+record.offset()+"key"+record.key()+"value"+record.value());
            }
        }

    }

}
