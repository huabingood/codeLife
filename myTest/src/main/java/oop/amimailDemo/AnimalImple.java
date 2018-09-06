package oop.amimailDemo;

/**
 * 描述：
 * 这个是抽象类，实现了接口的部分方法，并定义一个抽象方法，给孩子
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-06
 */
public abstract class AnimalImple implements AnimalActive {
    private String name;
    private int age;

    public AnimalImple() {
    }

    public AnimalImple(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void eat(AnimalImple animalImple) {
        System.out.println(animalImple.getName() + "正在吃饭。");
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + "正在睡觉");
    }

}
