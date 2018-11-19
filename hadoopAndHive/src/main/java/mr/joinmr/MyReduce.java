package mr.joinmr;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Null的序列化对应字段是：NullWritable
 */
public class MyReduce extends Reducer<Text,InfoBean,InfoBean, NullWritable> {


    @Override
    protected void reduce(Text key, Iterable<InfoBean> values, Context context) throws IOException, InterruptedException {
        ArrayList<InfoBean> orderBeans = new ArrayList<>();
        ArrayList<InfoBean> productBeans = new ArrayList<>();

        InfoBean middle = new InfoBean();

        // 分别将两个bean加入不同的list中，然后做二层遍历；因为join存在n:n的可能

        // 这种方法不知道为什么会导致ArrayList中的对象时同一个。
        // 好像infoBean每次都是一个同一个空间
/*        for (InfoBean infoBean : values) {
            if (infoBean.getFlag().equals("product") ){
                middle = infoBean;
                productBeans.add(middle);

            } else if(infoBean.getFlag().equals("order")) {
                middle  =infoBean;
                orderBeans.add(middle);

            }
        }*/

        for (InfoBean infoBean : values) {
            if (infoBean.getFlag().equals("product") ){
                try {
                    BeanUtils.copyProperties(middle,infoBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                productBeans.add(middle);

            } else if(infoBean.getFlag().equals("order")) {

                InfoBean middle1  = new InfoBean();
                try {
                    BeanUtils.copyProperties(middle1,infoBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                orderBeans.add(middle1);

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
