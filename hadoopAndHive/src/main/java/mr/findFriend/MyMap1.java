package mr.findFriend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMap1 extends Mapper<LongWritable, Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(":|,");

        // 输出<友，人>，<友，人>，<友，人>
        for(int i=1;i<words.length;i++){
            context.write(new Text(words[i]),new Text(words[0]));
        }
    }
}
