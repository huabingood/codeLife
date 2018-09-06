package oop.amimailDemo;

/**
 * 描述：
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-06
 */
public class Cat extends AnimalImple {
    public Cat() {
    }

    // 调用构造时，调用父类的构造，不再调用默认的父类构造
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump(AnimalImple animalImple) {
        System.out.println(animalImple.getName() + "年龄是：" + animalImple.getAge() + "。能跳：" + AnimalActive.hige);
    }

    public void myOnly() {
        System.out.println("这是猫独有的方法");
    }
}
