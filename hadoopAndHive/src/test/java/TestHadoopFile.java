import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class TestHadoopFile {
    public static void main(String[] args){
        FileSystem fs = null;
        Configuration conf = null;

        conf = new Configuration();
        conf.set("HADOOP_USER_NAME","huabingood");

        try {
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileStatus[] files = null;
        try {

            files = fs.listStatus(new Path("/"));
            for(FileStatus file:files){
                System.out.println(file.getPath().toUri().getPath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
