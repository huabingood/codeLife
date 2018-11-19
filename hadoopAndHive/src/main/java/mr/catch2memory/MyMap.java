package mr.catch2memory;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyMap extends Mapper<LongWritable, Text,Text, NullWritable> {

    Map<String,String> id_panem_price = new HashMap<>();
    /**
     * 近运行一次，用于初始化map需要的参数和数据
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new FileReader("t_product.txt"));
        String line = null;
        while((line = br.readLine())!=null){
            String[] words  =line.split(",");
            // 将<产品id,产品名价格合并>放入内存中，然后再map中进行处理
            id_panem_price.put(words[0],words[1]+","+words[3]);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split(",");
        String product = id_panem_price.getOrDefault(words[2],"0");
        if(! "0".equals(product)){
            context.write(new Text(words[1]+","+product),NullWritable.get());
        }

    }
}
