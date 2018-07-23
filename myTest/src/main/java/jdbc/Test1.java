package jdbc;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库连接
 * 1.获取配置信息
 * 2.根据配置信息获取连接
 * 3.执行SQL语句
 * 4.关闭各种连接
 */
public class Test1 {

    String dbDriver;
    String dbUrl;
    String dbUser;
    String dbPassWd;


    /**
     * 获取配置信息
     */
    public void getInfo(){
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

    public void getAllData(){
        Connection connection=null;

        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassWd);
            String sql = "select name from test2;";

            Statement ps = connection.createStatement();

            ResultSet resultSet = ps.executeQuery(sql);
            System.out.println(resultSet.getMetaData());
            System.out.println("");

            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }





}
