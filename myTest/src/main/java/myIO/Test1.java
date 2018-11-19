package myIO;

import java.io.*;


/**
 * 
 */
public class Test1 {
    public static void main(String[] args) throws FileNotFoundException {
        // 这个其实是装饰模式，作为最低一级的输出，需要传入高级的输出
        BufferedOutputStream bos  =new BufferedOutputStream(new FileOutputStream(new File("aaa")));

        BufferedReader br = new BufferedReader(new FileReader(new File("")));
    }
}
