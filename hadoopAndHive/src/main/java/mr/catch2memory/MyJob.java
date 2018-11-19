package mr.catch2memory;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utiles.HDFSCheck;

import java.net.URI;

public class MyJob {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf,"catch_mapJoin");

        Path inpath = new Path("/input/t_order.txt");
        Path outpath = new Path("/output/t_product.txt");
        HDFSCheck.ifExistRm(conf,outpath);

        // 将HDFS上的小文件分发到各个运算节点
        DistributedCache.addCacheFile(new URI("hdfs://ns1/input/t_product.txt"),conf);

        job.setJarByClass(MyJob.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setMapOutputKeyClass(Text.class);

        job.setNumReduceTasks(0);

        FileInputFormat.setInputPaths(job,inpath);
        FileOutputFormat.setOutputPath(job,outpath);

        boolean b = job.waitForCompletion(true);
        System.exit(b?1:0);
    }
}
