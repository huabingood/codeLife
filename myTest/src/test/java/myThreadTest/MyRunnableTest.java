package myThreadTest;

import myThread.MyRunable;

/**
 * 实现runnable接口创建多线程
 *  过程
 *  1.创建类实现Runnable接口
 *  2.重写Run() 方法
 *  3.实例化该类的对象
 *  4.根据对象创建Thread对象
 *  5.启动线程
 */
public class MyRunnableTest {
    public static void main(String[] args){
        // 1.实例化该类的对象
        MyRunable myRunable = new MyRunable();

        // 2.在创建线程的同时就给线程起别名
        Thread thread1 = new Thread(myRunable,"我是线程一");
        Thread thread2 = new Thread(myRunable,"我是线程二");
        Thread thread3 = new Thread(myRunable,"我是线程三");

        // 3.启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
