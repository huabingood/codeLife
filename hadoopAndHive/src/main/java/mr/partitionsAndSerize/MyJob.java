package mr.partitionsAndSerize;

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

        conf.set("fs.default.name", "hdfs://ns1");
        conf.set("hadoop.job.user", "huabingood");
        conf.set("mapreduce.framework.name","yarn");
        conf.set("yarn.resourcemanager.hostname","huabingood02");

        Job job = Job.getInstance(conf);

        Path inpath = new Path("/input/test/test.log");
        Path outpath = new Path("/output/o1");
        HDFSCheck.ifExistRm(conf, outpath);

        job.setJobName("partitionAndSerize");
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(4);

        FileInputFormat.setInputPaths(job, inpath);
        FileOutputFormat.setOutputPath(job, outpath);

        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "success" : "failed");
    }
}
