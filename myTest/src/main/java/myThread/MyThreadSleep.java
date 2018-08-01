package myThread;

import java.util.Date;

public class MyThreadSleep  extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(getName()+i+",现在是："+new Date());

            try {
                // 休眠的时间单位是毫秒
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
