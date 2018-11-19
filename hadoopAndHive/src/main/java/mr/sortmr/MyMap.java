package mr.sortmr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text,SortFlowBean,Text> {

    // 对方放在这里可以不用每次都创建一个新的对象，但是不容易被回收
    SortFlowBean sfb = new SortFlowBean();
    Text text = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString()
                .split("\t");

        if(words.length>5) {
            sfb.set(Long.parseLong(words[words.length - 3]),Long.parseLong(words[words.length - 2]));
            text.set(words[1]);
        }
        // 这里是Bean作为键，因为MR在shuffle过程中，只对键进行排序和分区。
        // 因为是Bean作为键，所以值就成了手机号，因此 只要Bean不同，即使手机号相同，也会被认为是不同的数据。无法对相同手机号
        // 的总流量进行汇总。
        context.write(sfb,text);
    }
}