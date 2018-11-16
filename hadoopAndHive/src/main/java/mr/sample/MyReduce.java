package mr.sample;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.w3c.dom.Text;

import java.io.IOException;

/**
 * keyin map输出的key
 * valuein map输出的1
 * keyout 被统计的单词
 * vlaueout 被统计单词的次数
 *
 */

public class MyReduce extends Reducer<Text, IntWritable,Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int num=0;
        for(IntWritable value:values){
            num+=value.get();
        }

        context.write(key,new LongWritable(num));
    }
}
