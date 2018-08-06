package myThread;

public class MyThreadSync implements Runnable {

    private int i = 100;
    Object obj = new Object();


    /**
     * 正常
     */
/*    public void run() {
        while (true) {
            synchronized (obj) {
                if (i > 0) {
                    i = i-1;
                } else {
                    break;
                }

            }
            System.out.println(Thread.currentThread().getName() + i);

        }
    }*/

    /**
     * 异常
     * 是因为a没有被同步，最后输出的结果会存在问题
     */
/*    public void run() {
        int a = 10;
        while (true) {

            synchronized (obj) {

                if (a > 0) {
                    i=i-1;
                    a=i;
                } else {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + a);
            }



        }

    }*/


    public void run(){

    }

}