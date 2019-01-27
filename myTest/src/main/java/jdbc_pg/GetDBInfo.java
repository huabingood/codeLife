package jdbc_pg;

import java.io.*;
import java.util.Properties;

public  class GetDBInfo {
    static String dbDriver;
    static String dbUser;
    static String dbPassWd;
    static String dbUrl;

    // 初始化时直接读取配置信息
    static {
        getInfo();
    }

    public GetDBInfo() {
    }

    public static String getDbDriver() {
        return dbDriver;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassWd() {
        return dbPassWd;
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    /**
     * 从配置文件中获取各种配置信息
     */
    private static void getInfo(){
        Properties properties = new Properties();
        String propPath =System.getProperty("user.dir")+ File.separator+"src/main/resources/pg.properties";
        InputStreamReader in;
        try {
            in= new InputStreamReader(new FileInputStream(new File(propPath)),"utf-8");
            properties.load(in);
            dbDriver=properties.getProperty("dbdriver");
            dbUrl=properties.getProperty("dburl");
            dbUser=properties.getProperty("dbuser");
            dbPassWd=properties.getProperty("dbpasswd");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

