package practise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 测试java8中的lambda和stream
 * 实际上 lambda就是scala中的匿名函数
 * stream 就是scala中的高阶函数
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-06
 */
public class LambdaAndFunction {

    @Test
    public void test1() {
        // 测试java8中的stream
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.stream().forEach(x -> System.out.println(x));
    }
}