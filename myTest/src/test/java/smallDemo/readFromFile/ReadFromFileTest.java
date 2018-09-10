package smallDemo.readFromFile;

import org.junit.Test;

/**
 * 描述：
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-10
 */
public class ReadFromFileTest {
    @Test
    public void testGetData() {
        ReadFromFile rff = new ReadFromFile();
        String sql = "select title,isbn13,authors from luka_biz.t_book where isbn13 in (" + rff.getData() + ");";
        System.out.println(sql);
    }
}
