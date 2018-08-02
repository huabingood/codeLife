package myThread;

/**
 * 通过实现Runnable接口来实现多线程
 * 步骤：
 *  1.创建类实现Runnable接口
 *  2.重写run()方法
 *  3.创建该类的实例
 *  4.通过该类的实例创建Thread对象
 *  5.根据Thread对象启动多线程
 *
 * 注意：
 *  1.线程的名称：只能获取当前线程的名称
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            // 获取当前线程的名称
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+":"+i);
        }
    }
}
