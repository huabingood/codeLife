package myThread;

/**
 * 普通的线程对象
 */
public class TreadPool implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"输出的值是："+i);
        }
    }
}

