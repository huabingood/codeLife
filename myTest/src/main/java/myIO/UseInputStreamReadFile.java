package myIO;

import java.io.*;

/**
 * 使用字节缓冲区流将影片复制到另外一个目录
 * 读流程
 * 1.打开一个缓冲区流
 * 2.一次读取2K的数据
 * 3.写入数据
 * 4.关闭输入缓冲区流
 */
public class UseInputStreamReadFile {

    public static void main(String[] args) {
        String startFile = "D:\\学习\\Java\\1.java基础\\day27\\avi\\27.25_JDK8新特性(接口中也可以有方法了).avi";
        String endFile = "C:\\Users\\huabingood\\Desktop\\新建文件夹\\a.avi";

        InputStream is = null;
        OutputStream os = null;

        try {
            // 这里就是一个装饰类，需要传入一个字节输入流
            is = new BufferedInputStream(new FileInputStream(startFile));
            os = new BufferedOutputStream(new FileOutputStream(endFile));

            // 一次写2K的数据
            byte[] bytes = new byte[1024 * 512];
            // 返回的是读入的数据的长度，如果是最后一行，返回-1。这一行不写到while里面会出问题
            // int len = is.read(bytes);
            int len = 0;

            while ((len=is.read(bytes))!= -1) {
                // 每一从0开始写，写到字符串的长度为止，防止最后一行不是2048个字节
                os.write(bytes, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 缓冲区最好在关闭之前刷新一下
            try {
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 关掉输入输出流
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
