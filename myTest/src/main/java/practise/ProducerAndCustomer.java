package practise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndCustomer {
    private static Integer count = 0;
    //创建一个阻塞队列
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        ProducerAndCustomer test3 = new ProducerAndCustomer();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
