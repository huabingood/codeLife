package mr.testlog;

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
        // 提交到yarn上运行，没有这些就是单机模式的，即使有配置文件
        // 在jar的情况下不需要设置
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("yarn.resourcemanager.hostname", "huabingood02");
        conf.set("yarn.nodemanager.aux-services", "mapreduce_shuffle");

        Job job = Job.getInstance(conf);

        Path outPath = new Path("/output/o1");
        HDFSCheck.ifExistRm(conf, outPath);

        job.setJobName("TestLog");
        job.setMapperClass(mr.testlog.MyMap.class);
        job.setReducerClass(mr.testlog.MyReduce.class);

        job.setMapOutputValueClass(Text.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path("/input/test/test.log"));
        FileOutputFormat.setOutputPath(job, outPath);

        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "success" : "failed");

    }
}
