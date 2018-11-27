package mr.findFriend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 输入 <友，人人人>
 * 输出 <人-人，友> <人-人，友> 的形式
 */
public class MyMap2 extends Mapper<LongWritable, Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] persons = value.toString().split(",");

        for(int i=0;i<persons.length;i++){
            for(int j = i+1;j<persons.length;j++){
                context.write(new Text(persons[i]+"-"+persons[j]),value);
            }
        }
    }
}
