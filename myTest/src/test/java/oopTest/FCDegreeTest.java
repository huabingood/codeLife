package oopTest;

import oop.FCDegree;
import org.junit.Test;

/**
 * 描述：
 *  华氏温度摄氏温度相互转换的测试
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-08-31
 */
public class FCDegreeTest {
    @Test
    public void test0(){
        FCDegree fcDegree = new FCDegree();
        System.out.println(fcDegree.c2f(23));
        System.out.println(fcDegree.f2c(23));
    }
}
