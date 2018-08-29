package myIO;

import java.io.Serializable;

public class PersonBean implements Serializable {
    private String name;
    private int age;
    //private final long serialVersionUID = -5809782578272943999L;

    public PersonBean() {
    }

    public PersonBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
