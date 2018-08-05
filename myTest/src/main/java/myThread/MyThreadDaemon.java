package myThread;

/**
 * 设置线程
 * 继承Thread类
 * 重写run方法
 * run方法中线程休眠1秒，并打印线程名称
 */
public class MyThreadDaemon extends Thread{
    @Override
    public void run() {
        for(int i=1;i<10;i++){
            try {
                sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+i);
        }
    }
}
