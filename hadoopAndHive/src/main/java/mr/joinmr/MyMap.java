package mr.joinmr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text,Text,InfoBean> {
    private final String ORDER_NAME="t_order.txt";
    private final String PRODUCT_NAME="t_product.txt";
    private final char ORDER_FLAG=0;
    private final char PRODUCT_FLAG=1;

    InfoBean infoBean = new InfoBean();
    Text text = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取当前split的文件名
        // getInputSplit返回的是FileSplit,而FileSplit则是可以获取路径的名称，而getInputSplit没有响应的方法
        String fileName = ((FileSplit)context.getInputSplit()).getPath().getName();

        String[] fields = value.toString().split(",");

        // 按照文件名的不同，将数据抽取到bean中并标注文件信息
        // 以join的on条件作为key
        if(fileName.equals(ORDER_NAME)){
            infoBean.setId(fields[0]);
            infoBean.setDate(fields[1]);
            infoBean.setFlag(ORDER_FLAG);
            text.set(fields[2]);
        }else if(fileName.equals(PRODUCT_NAME)){
            infoBean.setPname(fields[1]);
            infoBean.setPrice(Double.parseDouble(fields[3]));
            infoBean.setFlag(PRODUCT_FLAG);
            text.set(fields[0]);
        }

        context.write(text,infoBean);


    }
}
