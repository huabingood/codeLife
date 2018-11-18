package mr.sortmr;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyReduce extends Reducer<SortFlowBean, Text,Text,SortFlowBean> {

    @Override
    protected void reduce(SortFlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 输出的时候，号码在前，流量在后
        context.write(values.iterator().next(),key);
    }
}
