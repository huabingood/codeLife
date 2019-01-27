package jdbc_pg;

import java.sql.*;

public class PGUtils {
    Connection con = null;
    {
        getPGConnection();
    }

    private void getPGConnection() {
        try {
            Class.forName(GetDBInfo.getDbDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(GetDBInfo.getDbUrl(), GetDBInfo.getDbUser(), GetDBInfo.getDbPassWd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMetaData(String sql) throws Exception{
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println(rs);

        rs.close();
        con.close();
    }
}
