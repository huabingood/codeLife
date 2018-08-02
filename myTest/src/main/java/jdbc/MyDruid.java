package jdbc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

public class MyDruid {
    static Logger logger = LogManager.getLogger();

    private static DruidDataSource druidDataSource = null;
    private static MyDruid myDruid= null;

    /**
     * 实现单例模式，保证全局只有一个数据库连接池
     */
    static{
        Properties properties = new Properties();
        File file = new File("C:\\code\\codeLife\\myTest\\src\\main\\resources\\db_server.properties");
        try {
            InputStreamReader in = new InputStreamReader(new FileInputStream(file),"utf-8");
            properties.load(in);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("反正使用工厂模式，创建单例类的数据库连接错误！");
        }
    }

    /**
     * 单例类，只能我创建，构造不给别人
     * @return
     */
    public static synchronized MyDruid getInstance(){
        if(null==myDruid){
            myDruid=new MyDruid();
        }

        return myDruid;
    }

    /**
     * 获取连接，只能有单例类获取连接
     * @return
     * @throws SQLException
     */
    public DruidPooledConnection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }


}
