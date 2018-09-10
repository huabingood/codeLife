package myThreadTest;

import myThread.DeadLock;

/**
 * 反正没有实现死锁
 */
public class DeadLockTest {
    public static void main(String[] args){
        DeadLock d = new DeadLock();

        Thread t1 = new Thread(d,"刘备");
        Thread t2 = new Thread(d,"张飞");

        t1.start();
        t2.start();
    }

}
