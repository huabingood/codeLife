package oopTest.animailDemo;

import oop.amimailDemo.AnimalImple;
import oop.amimailDemo.Cat;
import org.junit.Test;

/**
 * 描述：
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-06
 */
public class CatTestJava {
    @Test
    public void testPolymorphic() {
        AnimalImple ai = new Cat("喵喵", 2);
        ai.jump(ai);
        // 调用独有方法必须类型转换
        ((Cat) ai).myOnly();
        ai.eat(ai);
        // 抽象的方法并不一定需要传入对象，公共的方法，公共调用即可，私有方法交给具体实现子类来做。
        ai.sleep();


    }
}
