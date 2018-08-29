package oop;

public class OopTest {
    private String name;
    private int age;

    public OopTest() {
    }

    public OopTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study(){
        System.out.println("I'm study.");
    }

}

class TestDemo{
    public static void main(String[] args){
        OopTest ooptest = new OopTest();
        ooptest.setName("huabingood");
        ooptest.setAge(18);
        ooptest.study();
    }

}
