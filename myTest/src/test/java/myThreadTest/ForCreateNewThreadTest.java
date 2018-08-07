package myThreadTest;

import myThread.ForCreateNewThread;

/**
 * 使用for循环生成线程
 */
public class ForCreateNewThreadTest {
    public static void main(String[] args){
        ForCreateNewThread forCreateNewThread = new ForCreateNewThread();
        for(int i=0;i<20;i++){
            Thread thread = new Thread(forCreateNewThread);
            thread.start();
        }
    }
}
