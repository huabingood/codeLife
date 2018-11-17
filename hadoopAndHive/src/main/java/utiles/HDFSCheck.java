package utiles;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public  class HDFSCheck {


    /**
     *
     * @param conf
     * @param path
     * @throws IOException
     */
    public static void ifExistRm(Configuration conf ,Path path) throws IOException {
        FileSystem fs = FileSystem.get(conf);

        if(fs.isDirectory(path)){
            fs.delete(path,true);
        }
    }
}
