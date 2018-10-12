package designModel.singleInstance;

public class Lazy {
    private String name;
    private int age;
    private char gender;

    // 第一步：构造方法私有
    private Lazy() {
    }

    // 第二步：创建对象
    private static Lazy laze = new Lazy();

    // 第三步：提供可供外界访问的对象
    public static Lazy getLazyInstance() {
        return laze;
    }
}
