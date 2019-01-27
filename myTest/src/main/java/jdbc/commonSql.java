package jdbc;

import java.io.*;
import java.util.Properties;

public class commonSql {
    String dbDriver;
    String dbUser;
    String dbPassWd;
    String dbUrl;

    /**
     * 从配置文件中获取各种配置信息
     */
    private void getInfo(){
        Properties properties = new Properties();
        String propPath =System.getProperty("user.dir")+File.separator+"src/main/resources/info.properties";
        InputStreamReader in;
        try {
            in= new InputStreamReader(new FileInputStream(new File(propPath)),"utf-8");
            properties.load(in);
            dbDriver=properties.getProperty("dbDriver");
            dbUrl=properties.getProperty("dbUrl");
            dbUser=properties.getProperty("dbUser");
            dbPassWd=properties.getProperty("dbPassWd");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
