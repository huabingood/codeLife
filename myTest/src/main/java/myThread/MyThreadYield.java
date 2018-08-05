package myThread;

/**
 * 线程礼让，执行到礼让线程时，则该线程让出执行权，大家共同抢（包括让出执行权的线程）
 * 继承runnable实现多线程
 * 重写run方法
 * yield() 方法有Thread调用，
 */
public class MyThreadYield implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"抢到线程");
            Thread.yield(); // 线程礼让
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
