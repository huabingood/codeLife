package jdbc;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDruidTest {
    @Test
    public void testConnection()  {
        MyDruid myDruid = MyDruid.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement prest = null;
        ResultSet rs = null;

        try {
            connection = myDruid.getConnection();
            String sql = "select * from test6;";
            prest = connection.prepareStatement(sql);
            rs = prest.executeQuery();
            while(rs.next()){
                String result = rs.getString(1);
                System.out.println(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(prest!=null){
                try {
                    prest.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
