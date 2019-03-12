package generic;

/**
 * 泛型类
 * 就是在类名后面添加泛型，然后就可以实现参数类型的任意化
 * 加在类名后面为了编译时进行检查
 * @param <T>
 */
public class Generic1<T> {
    private T t;

    public Generic1() {
    }

    public Generic1(T t) {
        this.t = t;
    }

    public void show(){
        System.out.println(t);
    }
}
