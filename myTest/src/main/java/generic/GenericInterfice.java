package generic;

/**
 * 泛型接口就是在接口后面指定泛型，然后在其实现子类上继续使用泛型
 * @param <name>
 * @param <age>
 */
public interface GenericInterfice<name,age> {

    void show();

}
