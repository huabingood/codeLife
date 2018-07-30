package myThreadTest;

import myThread.MyThread;

/**
 * 创建多线程的方法：
 *  1.创建继承Thread的类
 *  2.重写run方法：标注哪些方法需要多线程
 *  3.创建对象
 *  4.启动多线程
 * 小知识点：获取当前的线程名称
 */
public class MyThreadTest {

        public static void main(String[] args){
            // 3.实例化对象
            MyThread myThread1 = new MyThread();
            MyThread myThread2 = new MyThread();

            // 给线程设置名称
            myThread1.setName("线程一");
            myThread2.setName("线程二");

            // 4.启动线程
            myThread1.start();
            myThread2.start();

            // 获取当前线程的名称
            System.out.println("当前线程名称是："+Thread.currentThread().getName());
        }
}

