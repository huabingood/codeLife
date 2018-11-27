package mr.findFriend;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 返回<友，人人人人>的格式
 * 拼接放在第二步的map中会更好。
 */
public class MyReduce1 extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        StringBuffer sb = new StringBuffer();

        for(Text friend:values) {
            String f = friend.toString();
            if (sb.indexOf(f)==-1) {
                sb.append(f).append(",");
            }
        }

        context.write(key,new Text(sb.toString()));

    }
}
