package myThreadTest;

import myThread.TreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args){
        // 创建有三个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 提交任务
        pool.submit(new TreadPool());
        pool.submit(new TreadPool());

        // 会等待所以新提交的任务结束后才结束
        pool.shutdown();


    }
}
