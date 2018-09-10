package myThreadTest;

import myThread.Customer;
import myThread.Producer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 对消费者生产者的调用
 * 针对单生产-多消费者模型的停止
 * 有几个消费者就给出几个毒丸，使用者消费者数量已知的情况。
 */
public class ProducerCustomerTest {
    public static void main(String[] args){
        // 进行资源共享的队列
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);

        Producer producer = new Producer(arrayBlockingQueue);
        Customer customer1 = new Customer(arrayBlockingQueue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(customer1,"张飞");
        Thread thread3 = new Thread(customer1,"刘备");
        Thread thread4 = new Thread(customer1,"关羽");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
