package designModel.factory;

public class MingDynasty implements DynastyFactory {
    @Override
    public Dynasty getDynastyInstance() {
        return new Ming();
    }
}
