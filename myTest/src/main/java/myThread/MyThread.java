package myThread;

/**
 * 创建多线程的方法：
 *  1.创建继承Thread的类
 *  2.重写run方法：标注哪些方法需要多线程
 *  3.创建对象
 *  4.启动多线程
 * 小知识点：获取当前的线程名称
 */
public class MyThread extends Thread {
    /**
     * 通过run方法标注那些方法是需要多线程的
     */
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            // 使用getName()方法获取进程的名字
            System.out.println(getName()+":"+i);
        }
    }
}
