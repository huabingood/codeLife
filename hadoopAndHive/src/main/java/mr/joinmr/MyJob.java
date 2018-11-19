package mr.joinmr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utiles.HDFSCheck;

import java.io.IOException;

public class MyJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();

        Job job  = Job.getInstance(conf,"join");
        Path inPath1 = new Path("/input/t_order.txt");
        Path inPath2 = new Path("/input/t_product.txt");
        Path outPath = new Path("/output/o1");
        HDFSCheck.ifExistRm(conf,outPath);



        job.setJarByClass(MyJob.class);
        job.setMapperClass(MyMap.class);
        // job.setReducerClass(myReduce.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(InfoBean.class);
//        job.setOutputKeyClass();
//        job.setOutputValueClass();

        FileInputFormat.setInputPaths(job,inPath1,inPath2);
        FileOutputFormat.setOutputPath(job,outPath);

        boolean res= job.waitForCompletion(true);
        System.exit(res?1:0);
    }

}
