package mr.invertedindex;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text,Text,IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取当前分片的文件名
        String fileName = ((FileSplit)context.getInputSplit()).getPath().getName();

        String[] words = value.toString()
                .split(" ");

        for(String word:words){
            Text mapOutKey = new Text(word+"-"+fileName);
            context.write(mapOutKey,new IntWritable(1));
        }
    }
}
