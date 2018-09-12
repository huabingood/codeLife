package myIO;

import org.junit.Before;
import org.junit.Test;

/**
 * 描述：
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-12
 */
public class IOPractiseTest {
    IOPractise iop = null;

    @Before
    public void getInstance() {
        iop = new IOPractise();
    }

    @Test
    public void fileReadAndWriterTest() {
        String start = "C:\\Users\\huabingood\\Desktop\\面向对象\\9787556119745.jpg";
        String end = "C:\\Users\\huabingood\\Desktop\\面向对象\\9787559620170.jpg";
        iop.fileReadAndWriter(start, end);
    }

    @Test
    public void readerAndWriterTest() {
        String start = "C:\\Users\\huabingood\\Desktop\\下载图片\\download.txt";
        String end = "C:\\Users\\huabingood\\Desktop\\下载图片\\新建文本文档.txt";
        iop.readerAndWriter(start, end);
    }

}
