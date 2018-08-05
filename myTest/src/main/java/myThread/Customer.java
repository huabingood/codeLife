package myThread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消费者对产生的数据进行消费
 */
public class Customer implements Runnable{
    ArrayBlockingQueue<String> arrayBlockingQueue = null;

    public Customer(ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    /**
     * 消费的核心是将取到的数据输出
     */
    @Override
    public void run() {
        while (true)
            try {
                String s = arrayBlockingQueue.take();
                // 碰到毒丸就结束线程
                if(s=="毒丸"){
                    break;
                }
                System.out.println(s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
