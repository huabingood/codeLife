package oop;

/**
 * 描述：
 *  测试各个基本数据类型初始化的值
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-05
 */
public class VariableInitialValue {
    private int i;
    private boolean b;
    private long l;
    private float f;
    private double d;
    private short s;
    private char c;

    public VariableInitialValue(int i, boolean b, long l, float f, double d, short s, char c) {
        this.i = i;
        this.b = b;
        this.l = l;
        this.f = f;
        this.d = d;
        this.s = s;
        this.c = c;
    }

    public VariableInitialValue() {
    }

    public void getAll(){
        System.out.println("int is :" + i);
        System.out.println("boolean is :" + b);
        System.out.println("long is :" + l);
        System.out.println("float is :" + f);
        System.out.println("double is :" + d);
        System.out.println("short is :" + s);
        System.out.println("char is :" + c);
    }

}

