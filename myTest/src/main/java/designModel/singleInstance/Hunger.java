package designModel.singleInstance;

/**
 * 懒汉式的单例模式
 * 多线程情况下懒汉式会出问题，最好在创建对象时给加上锁
 */
public class Hunger {
    private String name;

    // 第一步：私有构造
    private Hunger() {
    }

    // 第二步：创建空的实例
    private static Hunger hunger = null;

    // 第三步：在访问时才创造真正的实例并返回
    // 这种方式在多线程下会出现问题，因此建议加上synchronized关键字
    public static synchronized Hunger getHungerInstance() {
        if (hunger == null) {
            hunger = new Hunger();
        }
        return hunger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hunger)) {
            return false;
        }

        Hunger hunger = (Hunger) o;

        return name != null ? name.equals(hunger.name) : hunger.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
