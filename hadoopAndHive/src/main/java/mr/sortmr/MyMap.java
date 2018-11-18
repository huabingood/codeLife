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
        sfb.setUpFlow(Long.parseLong(words[words.length-3]));
        sfb.setDownFlow(Long.parseLong(words[words.length-2]));
        text.set(words[1]);

        context.write(sfb,text);
    }
}
