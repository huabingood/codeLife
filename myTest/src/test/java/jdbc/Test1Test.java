package jdbc;

import org.junit.Test;

public class Test1Test {
    Test1 test1 = new Test1();
    @Test
    public void testGetInfo(){
        test1.getInfo();
        test1.getAllData();
    }
}
