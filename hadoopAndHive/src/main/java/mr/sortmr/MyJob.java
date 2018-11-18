package mr.sortmr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utiles.HDFSCheck;

import java.io.IOException;

public class MyJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf,"sort_all");

        Path intPath = new Path("/input/test/test.log");
        Path outPath = new Path("/outpath/o1");
        HDFSCheck.ifExistRm(conf,outPath);


        job.setJarByClass(MyJob.class);
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);

        job.setMapOutputKeyClass(SortFlowBean.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(SortFlowBean.class);

        FileInputFormat.setInputPaths(job,intPath);
        FileOutputFormat.setOutputPath(job,outPath);

        boolean res = job.waitForCompletion(true);
        System.out.println(res);

    }
}
