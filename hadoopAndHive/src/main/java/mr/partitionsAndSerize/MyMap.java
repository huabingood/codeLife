package mr.partitionsAndSerize;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 将一行数据按照制表符进行分割，然后将其中的 手机号码（第二个），上行流量（倒数第二个），下行流量（倒数第一个）去除
 * 将上行流量，下行流量传到Bean中
 */
public class MyMap extends Mapper<LongWritable, Text,Text,FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split("\t");

        if(words.length>3) {
            Text outKey = new Text(words[1]);
            FlowBean outValue = new FlowBean(Long.parseLong(words[words.length - 3]), Long.parseLong(words[words.length - 2]));
            context.write(outKey, outValue);
        }
    }
}
