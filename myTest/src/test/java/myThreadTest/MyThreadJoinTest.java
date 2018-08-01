package myThreadTest;

import myThread.MyThreadJoin;

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
