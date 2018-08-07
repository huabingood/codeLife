package myThread;

/**
 * 测试使用for循环生成线程
 */
public class ForCreateNewThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"输出的是："+i);
        }
    }
}
