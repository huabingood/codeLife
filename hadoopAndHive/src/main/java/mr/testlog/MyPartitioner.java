package mr.testlog;

import mr.partitionsAndSerize.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

/**
 * 这里的泛型就是map传出的context的内容
 * 分区是一个shuffle的过程
 */
public class MyPartitioner extends Partitioner<Text, FlowBean> {
    private HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
    {
        hashMap.put("135",1);
        hashMap.put("137",2);
        hashMap.put("139",3);
    }

    public MyPartitioner() {
    }


    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        String province = text.toString().substring(0,2);
        int provinceCode = hashMap.getOrDefault(province,0);
        return provinceCode;
    }
}
