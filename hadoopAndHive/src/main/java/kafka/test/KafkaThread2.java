package kafka.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Properties;

public class KafkaThread2 extends Thread {
    private  String topic;
    private int offset;
    private int start = 0;

    public KafkaThread2(String topic,int offset) {
        this.topic = topic;
        this.offset = offset;
    }

    private KafkaConsumer<String,String> createConsumer(){
        Properties props = new Properties();
        // bootstrap.servers设置要连接的Broker，多个可以使用逗号隔开。
        props.put("bootstrap.servers", "huabingood01:9092");
        props.put("group.id", "test1");
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
        return consumer;
    }

    @Override
    public void run() {
        KafkaConsumer<String,String> consumer = createConsumer();
        consumer.assign(Arrays.asList(new TopicPartition(topic,0),new TopicPartition(topic,1)));
        consumer.seek(new TopicPartition(topic,offset),start);

        while(true){
            // 后面的好像是如果数据失败，等待多少秒
            ConsumerRecords<String,String> records = consumer.poll(1000);
            for(ConsumerRecord record:records){
                System.out.println("offset:"+record.offset()+"key"+record.key()+"value"+record.value()+record.partition());
            }
        }
    }

    public static void main(String[] args) {
        new KafkaThread2("google",1).start();
        new KafkaThread2("google",0).start();

    }
}
