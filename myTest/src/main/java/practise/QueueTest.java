package practise;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
    public static void main(String[] args) throws Exception{
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();

        if(q==null|| q.isEmpty()){
            System.out.println("队列为空");
        }
        
        
        // 往阻塞队列中添加元素
        // 遵循FIFO的模式
        // put()在队列满了的时候回阻塞的
        q.put("刘备");
        q.put("关羽");
        q.put("张飞");

        System.out.println(q);

        // 从阻塞队列中移除一个元素
        // take() 在队列为空的时候也会阻塞
        System.out.println(q.take());

    }
}
