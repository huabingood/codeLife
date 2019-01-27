package jdbc_pg;

import org.junit.Test;

public class GetDBInfoTest {
    @Test
    public void getInfoTest(){
        System.out.println(GetDBInfo.getDbPassWd());
    }

    @Test
    public void getMetaDataInfo() throws Exception{
        String sql = "desc cities";
        // String sql = "select * from weather;";
        new PGUtils().getMetaData(sql);
    }
}
