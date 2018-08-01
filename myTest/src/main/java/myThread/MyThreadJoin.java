package myThread;

/**
 * join 是指所有的线程等待join线程执行完毕后再执行，有点顺序执行的味道
 * join命令必须在start之后，因为只有线程启动了，才能通知到是否等待该线程执行完毕
 * join通常是主线程等待该子线程完成，只是主线程在等待，与此同时已经启动的主线程是不受影响的
 *
 */
public class MyThreadJoin extends Thread {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(getName()+"："+i);
        }
    }
}
