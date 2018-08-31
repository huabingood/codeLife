package oop;

/**
 * 测试构造代码块
 */
public class CodeBlock {
    private String name;
    private int age;

    public CodeBlock(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("我在执行有参构造。");
    }

    public CodeBlock() {
        System.out.println("我在执行无参构造。");
    }

    // 构造代码块
    {
        this.name="huabingood";
        this.age=18;
        System.out.println("执行到了构造代码块。");
    }

    @Override
    public String toString() {
        return "CodeBlock{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
