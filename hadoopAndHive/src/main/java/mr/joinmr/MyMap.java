package mr.joinmr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text,Text,InfoBean> {
    InfoBean infoBean = new InfoBean();
    Text text = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取当前split的文件名
        String fileName = context.getInputSplit().toString();
        System.out.println(fileName);
    }
}
