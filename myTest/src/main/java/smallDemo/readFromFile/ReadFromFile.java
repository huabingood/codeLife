package smallDemo.readFromFile;

import java.io.*;

/**
 * 描述：
 * 输入：
 * 99  《与罗摩相会》
 * 100  《方尖碑之门》
 * <p>
 * 人物 类  30  本
 * 1  《高兴死了》
 * 2  《开心坏了》
 * 3  《最后的演讲》
 * 输出：
 * "与罗摩相会","方尖碑之门","高兴死了","开心坏了","最后的演讲"
 * 注意
 * 1.中间的空行不要，不是书名的不要
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-10
 */
public class ReadFromFile {
    private final String FilePath = "C:\\Users\\huabingood\\Desktop\\待处理文件.txt";
    private int i = 0; // 为了校验行数

    public ReadFromFile() {
    }

    /**
     * 读取数据，并拼接成字符串
     *
     * @return
     */
    public String getData() {
        String data = null;
        BufferedReader br = null;
        String line = null;


        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath), "GBK"));
            while ((line = br.readLine()) != null) {
                data = getStringLine(line, data);
            }
            System.out.println("共处理了" + i + "行数据。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    // 负责主要的拼接逻辑
    private String getStringLine(String line, String data) {
        // String data=null;
        if (line.contains("《")) {
            i++;
            String name = line.split("《")[1]
                    .split("》")[0];
            if (data != null) {
                data = data + "," + "\"" + name + "\"";
            } else {
                data = "\"" + name + "\"";
            }
        } else {
            System.out.println(line);
        }
        return data;
    }
}
