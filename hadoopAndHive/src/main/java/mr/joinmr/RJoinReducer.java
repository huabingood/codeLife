package mr.joinmr;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class RJoinReducer extends Reducer<Text,InfoBean,InfoBean, NullWritable> {
    @Override
    protected void reduce(Text pid, Iterable<InfoBean> beans, Context context) throws IOException, InterruptedException {
        InfoBean pdBean = new InfoBean();
        ArrayList<InfoBean> orderBeans = new ArrayList<InfoBean>();

        for (InfoBean bean : beans) {
            if ("product".equals(bean.getFlag())) {
                try {
                    BeanUtils.copyProperties(pdBean,bean);
                    //BeanUtils.copyProperties(pdBean, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                InfoBean odbean = new InfoBean();
                try {
                    BeanUtils.copyProperties(odbean, bean);
                    orderBeans.add(odbean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        // 拼接两类数据形成最终结果
        for (InfoBean bean : orderBeans) {

            bean.setPname(pdBean.getPname());
            bean.setPrice(pdBean.getPrice());

            context.write(bean, NullWritable.get());
        }
    }
}
