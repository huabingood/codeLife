package mr.findFriend;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 输入：<人-人，友> <人-人，友>
 * 输出：<人-人，友友友友> <人-人，友友友友>
 */
public class MyReduce2 extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuffer sb = new StringBuffer();

        for(Text friend:values){
            String f = friend.toString();
            if(sb.indexOf(f)==-1){
                sb.append(f).append(",");
            }
        }

        context.write(key,new Text(sb.toString()));
    }
}
