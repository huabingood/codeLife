package oop;

/**
 * 描述：
 * 成员内部类的声明，调用
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-07
 */
public class InnerClass {
    private String name = "外部类成员";

    /**
     * 局部内部类必须在本方法中实例化，才能调用内部类的方法，否者是不行的
     */
    public void methodInnerClass() {
        class Heart {
            public void getName() {
                System.out.println(InnerClass.this.name);
            }
        }
        new Heart().getName();
    }

    /**
     * 这里是一个成员内部类
     * 成员内部类的实例化是放在外部类实例化之后的
     * 注意jump方法访问不同的位置的变量的方式
     */
    class Heart {
        private String name = "内部类成员参数";

        public void jump() {
            String name = "局部参数";
            System.out.println("我是有名字的内部类，我可以访问外部类的name参数----" + this.name);
            System.out.println("外部私有的成员变量----" + InnerClass.this.name);    // 这里的this必须添加，否者会被误认为是静态方法
            System.out.println("内部类局部参数----" + name);
        }
    }
}

/**
 * 测试类
 */
class RunHere {
    public static void main(String[] args) {
        // 调用内部类的成员方法
        // 外部类.内部类 对象名 = 外部类对象.内部类对象；
        InnerClass.Heart ih = new InnerClass().new Heart();
        ih.jump();

        // 这里也是一种链式编程，只要返回的是对象，就可以一直调用其中的方法
        new InnerClass()
                .new Heart()
                .jump();


        new InnerClass().methodInnerClass();
    }
}
