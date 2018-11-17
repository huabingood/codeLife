package mr.testlog;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMap extends Mapper<Text, Text,Text,Text> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String line = key.toString();
        String[] words = line.split("\t");

        context.write(new Text(words[1]),new Text(words[-3]+","+words[-2]));
    }
}
