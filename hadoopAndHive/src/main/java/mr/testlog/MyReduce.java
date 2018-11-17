package mr.testlog;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class MyReduce extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 拼接上行流量，下行流量，总流浪
        long upload = 0L;
        long download = 0L;
        long total = 0L;
        for(Text value:values){
            String[] flu = value.toString().split(",");
            long ul = Long.parseLong(flu[0]);
            long dl = Long.parseLong(flu[1]);
            upload +=ul;
            download+=dl;
        }
        total = upload+download;

        Text value = new Text("上行流量是："+upload+"，下行流量是："+download+"，总流量是："+total);

        context.write(key,value);
    }
}
