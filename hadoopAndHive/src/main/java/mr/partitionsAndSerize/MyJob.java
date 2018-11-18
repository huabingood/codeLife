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

        // 同时指定该job的名字
        Job job = Job.getInstance(conf,"huabingood_jar");

        Path inpath = new Path("/input/test/test.log");
        Path outpath = new Path("/output/o1");
        HDFSCheck.ifExistRm(conf, outpath);

        // 这里必须这样写，否者打成jar运行时会出现异常
        job.setJarByClass(mr.partitionsAndSerize.MyJob.class);

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
