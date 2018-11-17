package mr.sample;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import utiles.HDFSCheck;

import java.io.IOException;

/**
 * 相当于一个yarn集群的客户端
 * 需要我们封装MR的相关参数，指定jar包
 * 最后提交给yarn
 * mapreduce是新的API，mapred是旧的API
 */
public class RunHere {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 获取配置
        Configuration conf = new Configuration();

        // 提交到yarn上运行，没有这些就是单机模式的，即使有配置文件
        // 在jar的情况下不需要设置
        // 我不知道为什么设置了没有用，可能是因为我在Hadoop的client上提交的任务
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("yarn.resourcemanager.hostname", "huabingood02");
        conf.set("yarn.nodemanager.aux-services", "mapreduce_shuffle");


        Path outPath = new Path("/outpath/o2");
        HDFSCheck.ifExistRm(conf, outPath);


        // 启动一个任务
        Job job = Job.getInstance(conf);

        // 使用的map类和reduce类
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);

        // 设置输出的参数类型，因为是可拔插的，所以必须指定
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 输入输出路径
        FileInputFormat.setInputPaths(job, new Path("/input/*"));
        FileOutputFormat.setOutputPath(job, outPath);

        // 告诉yarn运行的主类
        job.setJarByClass(RunHere.class);

        // 将job给yarn，并打印任务是否成功
        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "success" : "failed");
    }

}
