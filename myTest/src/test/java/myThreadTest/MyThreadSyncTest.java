package myThreadTest;


import myThread.MyThreadSync;

public class MyThreadSyncTest {
    public static void main(String[] args){

        MyThreadSync myThreadSync  = new MyThreadSync();

        Thread thread1 = new Thread(myThreadSync,"刘备");
        Thread thread2 = new Thread(myThreadSync,"关羽");
        Thread thread3 = new Thread(myThreadSync,"张飞");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
