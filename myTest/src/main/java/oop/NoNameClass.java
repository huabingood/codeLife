package oop;

/**
 * 描述：
 * 匿名内部类，多见于spark RDD 的开发
 * 反正我见到的不多
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-07
 */

interface NoName {
    void show();

    void getName();
}

public class NoNameClass {
    public static void main(String[] args) {
        // 匿名内部类，多用于
        NoName noName = new NoName() {
            public void show() {
                System.out.println("我是show方法。");
            }

            public void getName() {
                System.out.println("我是getName方法。");
            }
        };

        // 使用接口或者抽象类，有利于内部类多个方法的调用。
        noName.show();
        noName.getName();
    }
}
