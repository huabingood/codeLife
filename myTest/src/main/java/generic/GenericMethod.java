package generic;

/**
 * 泛型方法，实现参数类型的可变
 * 创建对象时不需要指定泛型
 * 使用方法时也不需要指定泛型，只要直接传进来即可
 */
public class GenericMethod {
    public <T> void show(T t){
        System.out.println(t);
    }
}
