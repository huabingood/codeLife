package myIO;

import java.io.*;

/**
 * 字符流读写
 * 使用字符缓冲区流，一次读取一行
 * 在输入流中使用true表示追加
 */
public class UseZiJie {
    public static void main(String[] args) {
        String startFile = "C:\\Users\\huabingood\\Desktop\\新建文件夹\\getAllInventoryBookData.txt";
        String endFile = "C:\\Users\\huabingood\\Desktop\\新建文件夹\\b.txt";

        // 创建读写流
        Reader reader = null;
        Writer writer = null;

        try {
            // 推荐使用第二种方式，因为可以指定编码格式
            // reader = new BufferedReader(new FileReader(startFile));
            reader = new InputStreamReader(new FileInputStream(startFile),"utf-8");
            writer = new BufferedWriter(new FileWriter(endFile,true));

            String line = null;

            // 按行读取，并按行写入
            while ((line = ((BufferedReader) reader).readLine()) != null) {
                writer.write(line); // 不会写入换行符
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭之前先刷新
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 各种关闭
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
