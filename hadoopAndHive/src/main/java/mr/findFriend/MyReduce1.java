package mr.findFriend;

import org.apache.commons.collections.IteratorUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.List;

/**
 * 返回<友，人人人人>的格式
 * 拼接放在第二步的map中会更好。
 */
public class MyReduce1 extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        List<Text> friends = IteratorUtils.toList(values.iterator());
        StringBuffer sb = new StringBuffer();

        for(Text friend:values){
            sb.append(friend.toString()).append(",");
        }

        context.write(key,new Text(sb.toString()));

    }
}
