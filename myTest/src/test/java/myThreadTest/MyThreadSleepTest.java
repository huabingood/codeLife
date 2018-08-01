package myThreadTest;

import myThread.MyThreadSleep;

public class MyThreadSleepTest {
    public static void main(String[] args){
        MyThreadSleep myThreadSleep1 = new MyThreadSleep();
        MyThreadSleep myThreadSleep2 = new MyThreadSleep();

        myThreadSleep1.setName("我是第一个线程");
        myThreadSleep2.setName("我是第二个线程");

        myThreadSleep1.start();
        myThreadSleep2.start();
    }
}
