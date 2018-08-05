package myThreadTest;


import myThread.MyThreadDaemon;

public class MyThreadDaemonTest {
    public static void main(String[] args){
        MyThreadDaemon m = new MyThreadDaemon();
        MyThreadDaemon m2 = new MyThreadDaemon();
        MyThreadDaemon m3 = new MyThreadDaemon();

        // 如果这里注释掉，在main线程结束后，子线程仍然会继续
        // 如果不注释，主线程死掉，子线程也就死掉了
        m.setDaemon(true);
        m2.setDaemon(true);
        m3.setDaemon(true);

        m.setName("李鸿章");
        m2.setName("曾国藩");
        m3.setName("张之洞");

        m.start();
        m2.start();
        m3.start();

        Thread.currentThread().setName("朕的大清");

        for(int i=10;i<15;i++){
            try {
                Thread.currentThread().sleep(1+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
