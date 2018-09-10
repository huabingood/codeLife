package myThread;

public class DeadLock implements Runnable {
    int i=0;
    Object obj = new Object();   // 锁对象

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"获得执行权");
            while(true){
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName()+"执行"+i);
                }else{
                    System.out.println(Thread.currentThread().getName()+"执行"+i);
                }
                i++;
            }
        }
    }
}
