package myIO;

import java.io.*;

/**
 * 描述：
 * 使用字节流字符流读写数据
 * 只有 字节字符写流才有追加，缓冲区流都没有这种功能
 * 只有 字节字符转换流才能准换编码格式
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-12
 */
public class IOPractise {
    /**
     * 使用字节缓冲区流读写文件，往文件中追加
     *
     * @param start 要读取的文件
     * @param end   要写入的文件
     */
    public void fileReadAndWriter(String start, String end) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int len = 0;

        try {
            bis = new BufferedInputStream(new FileInputStream(new File(start)));
            // FileOutputStream有追加的功能
            bos = new BufferedOutputStream(new FileOutputStream(new File(end), true));

            // 一次读取5K的数据
            byte[] bytes = new byte[1024 * 5];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.flush();
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用读写流往文本中
     *
     * @param start 输入文本
     * @param end   输出文本
     */
    public void readerAndWriter(String start, String end) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        String line = null;

        try {
            // InputStreamReader 是字符和字节流的转换流，转换流可以设置编码格式
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(start)), "utf-8"));
            bw = new BufferedWriter(new FileWriter(end, true));

            while ((line = br.readLine()) != null) {
                // 这样好像会把换行符给干掉 必须加上 System.lineSeparator()
                bw.write(System.lineSeparator() + line);
            }

            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
