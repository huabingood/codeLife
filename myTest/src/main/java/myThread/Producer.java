package myThread;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者生产数据，往定长的阻塞队列中塞数据
 * 有几个消费者线程，就塞入几个毒丸
 *
 */
public class Producer implements Runnable {
    ArrayBlockingQueue arrayBlockingQueue = null;

    public Producer(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }


    /**
     * 往定长阻塞数组中塞数据
     */
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                arrayBlockingQueue.put(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 放入毒丸，告知线程结束
        // 有几个消费者，就放入几个毒丸
        try {
            for(int i=0;i<3;i++) {
                arrayBlockingQueue.put("毒丸");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
