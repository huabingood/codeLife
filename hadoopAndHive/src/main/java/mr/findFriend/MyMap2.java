package mr.findFriend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

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
