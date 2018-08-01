package myThreadTest;

import myThread.MyThredPriority;

public class MyThreadPriorityTest {
    public static void main(String[] args){
        MyThredPriority mythredPriority1 = new MyThredPriority();
        MyThredPriority myThredPriority2 = new MyThredPriority();

        mythredPriority1.setName("我是线程一");
        myThredPriority2.setName("我是线程二");

        // 打印线程优先级
        System.out.println(mythredPriority1.getName()+"优先级是："+mythredPriority1.getPriority());
        System.out.println(myThredPriority2.getName()+"优先级是："+myThredPriority2.getPriority());

        // 赋予新的优先级
        // 值在[1,10]之间，1最低，10优先，默认是5
        // 线程分配有两种：
        // 1.时间分片
        // 2.抢占式（java中默认的）
        // 并不是线程优先级高就是优先执行，只是说优先执行的概率大
        mythredPriority1.setPriority(1);
        myThredPriority2.setPriority(6);

        // 执行多线程
        mythredPriority1.start();
        myThredPriority2.start();
    }
}
