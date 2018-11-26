package mr.findFriend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();

        Job job1 = Job.getInstance(conf,"job1");
        Job job2 = Job.getInstance(conf,"job2");

        // for job1
        job1.setJarByClass(MyJob.class);
        job1.setMapperClass(MyMap1.class);
        job1.setReducerClass(MyReduce1.class);

        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(Text.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(Text.class);

        FileOutputFormat.setOutputPath(job1,new Path(""));
        FileInputFormat.setInputPaths(job1,new Path(""));

        boolean b = job1.waitForCompletion(true);

        // for job2
        job2.setJarByClass(MyJob.class);
        job2.setMapperClass(MyMap2.class);
        job2.setReducerClass(MyReduce2.class);

        job2.setMapOutputKeyClass(Text.class);
        job2.setMapOutputValueClass(Text.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(Text.class);

        FileOutputFormat.setOutputPath(job2,new Path(""));
        FileInputFormat.setInputPaths(job2,new Path(""));



        boolean res = false;
        if(b){
            res = job2.waitForCompletion(true);
        }else{
            System.out.println("job1在执行过程中失败");
        }

        System.out.println(res?"任务成功":"任务失败");


    }
}
