package myThreadTest;

import myThread.MyThreadJoin;

/**
 * 线程join是在start()方法之后调用的，对于已启动的线程没有影响，
 * 是让主线程等待子线程的完成
 * 其后的线程，由于需要main线程调用，故无法启动
 */
public class MyThreadJoinTest {
    public static void main(String[] args){
        MyThreadJoin  myThreadJoin1 = new MyThreadJoin();
        MyThreadJoin myThreadJoin2 = new MyThreadJoin();

        myThreadJoin1.setName("线程一");
        myThreadJoin2.setName("线程二");

        myThreadJoin1.start();
/*        // 在start后调用，所有线程等待该线程执行完毕后才执行
        try {
            myThreadJoin1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        myThreadJoin2.start();

        try {
            myThreadJoin2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
