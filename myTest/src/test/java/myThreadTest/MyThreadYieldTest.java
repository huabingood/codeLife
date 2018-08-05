package myThreadTest;

import myThread.MyThreadYield;

/**
 * 线程礼让
 */
public class MyThreadYieldTest {
    public static void main(String[] args){
        MyThreadYield m = new MyThreadYield();

        Thread t1 = new Thread(m,"张飞");
        Thread t2 = new Thread(m,"刘备");
        Thread t3 = new Thread(m,"关羽");

        t1.start();
        t2.start();
        t3.start();

    }

}
