package myThreadTest;

import myThread.Customer;
import myThread.Producer;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerCustomerTest {
    public static void main(String[] args){
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
