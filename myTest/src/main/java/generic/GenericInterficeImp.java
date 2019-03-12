package generic;

import generic.GenericInterfice;

public class GenericInterficeImp<name,age> implements GenericInterfice<name,age> {

    private name n;
    private age a;

    public GenericInterficeImp(name n, age a) {
        this.n = n;
        this.a = a;
    }

    public GenericInterficeImp() {
    }


    @Override
    public void show() {
        System.out.println(n);
        System.out.println(a);
    }
}
