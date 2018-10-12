package designModel.factory;

public interface DynastyFactory {
    /**
     * 工厂接口，获取子类的对象
     *
     * @return 子类的对象
     */
    public abstract Dynasty getDynastyInstance();
}
