package mr.joinmr;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Null的序列化对应字段是：NullWritable
 */
public class MyReduce extends Reducer<Text,InfoBean,InfoBean, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<InfoBean> values, Context context) throws IOException, InterruptedException {
        ArrayList<InfoBean> orderBeans = new ArrayList<>();
        ArrayList<InfoBean> productBeans = new ArrayList<>();

        // 分别将两个bean加入不同的list中，然后做二层遍历；因为join存在n:n的可能
        for(InfoBean infoBean:values){
            if(infoBean.getFlag()==1){  // 包含产品信息的bean
                productBeans.add(infoBean);
            }else{
                orderBeans.add(infoBean);
            }
        }

        // 就按join的n:n的情况输出数据
        for(InfoBean orderBean:orderBeans){
            for(InfoBean productBean:productBeans){
                orderBean.setPrice(productBean.getPrice());
                orderBean.setPname(productBean.getPname());
                context.write(orderBean,NullWritable.get());
            }
        }

    }
}
