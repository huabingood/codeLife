package mr.sample;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 输入的数据：
 * keyin 可以理解为文本的行号，LongWritable
 * valuein 可以理解为读取的一行内容 Text
 * keyout 按指定分割符分割的该行所有的字符中的一个 Text
 * keyout 指定分割符分割的所有数据IntegerWritable
 *
 * Hadoop中为了方便的实现数据的网络传输，对所有的数据进行了序列化；其中String经过序列化的包装
 * 成了Text，其他的基本类型被包装后形成了各种~Writable 比如LongWritable
 */
public class MyMap extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        // 将一行的数据分割成无数个单词
        String[] words = line.split(",|;|\\.| |\\?|!");

        // stream中不会自动抛异常的
        /*Arrays.stream(words)
                .forEach(word->context.write(new Text(word),new IntWritable(1)));*/

        for(String word:words){
            // 将分割的单词拼接成<单词，1> 返回给 shuffle
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
