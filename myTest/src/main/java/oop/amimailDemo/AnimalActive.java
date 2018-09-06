package oop.amimailDemo;

/**
 * 描述：
 * 这个抽象类主要定义动物的抽象行为
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-06
 */
public interface AnimalActive {
    // 接口成员变量默认是public static final 修饰
    int hige = 10;

    // 抽象方法默认是public abstract 修饰
    void eat(AnimalImple animalImple);

    void sleep();

    void jump(AnimalImple animalImple);
}
