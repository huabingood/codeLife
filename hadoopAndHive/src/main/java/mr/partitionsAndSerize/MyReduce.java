package mr.partitionsAndSerize;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class MyReduce extends Reducer<Text,FlowBean,Text,FlowBean> {
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long upflow = 0;
        long downflow = 0;
        for(FlowBean fb:values){
            // 实际上FlowBean在传输的过程中自动进行了序列化和反序列化
            upflow += fb.getUpflow();
            downflow += fb.getDownflow();
        }
        // 总流量在对象初始化时进行赋值
        // reduce持久化到本地时对象，实际上持久化的是对象的toString()方法
        context.write(key,new FlowBean(upflow,downflow));
    }
}
