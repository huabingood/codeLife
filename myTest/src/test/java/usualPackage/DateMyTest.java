package usualPackage;

import org.junit.Before;
import org.junit.Test;

/**
 * 描述：
 * JDK8.0 新的时间API的测试
 * 将创建对象作为一个成员变量，然后再Before中实例化他，这样减少了代码的重复读
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-11
 */
public class DateMyTest {
    private DateMy dateMy;

    @Before
    public void getInstance() {
        dateMy = new DateMy();
    }

    @Test
    public void getObjectTest() {
        dateMy.getObject();
    }

    @Test
    public void getNowtimeTest() {
        dateMy.getNowtime();
    }

    @Test
    public void getSingleTimeTest() {
        dateMy.getSingleTime();
    }

    @Test
    public void getSpecialTimeTest() {
        dateMy.getSpecialTime();
    }


    @Test
    public void aboutTimeZoneTest() {
        dateMy.aboutTimeZone();
    }

    @Test
    public void timeZoneConvertTest() {
        dateMy.timeZoneConvert();
    }

    @Test
    public void str2DateTest() {
        dateMy.str2Date();
    }

    @Test
    public void date2StrTest() {
        dateMy.date2Str();
    }

    @Test
    public void getDiffDateTest() {
        dateMy.getDiffDate();
    }

}
