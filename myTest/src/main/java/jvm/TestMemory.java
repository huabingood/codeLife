package jvm;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {

    static class Obj{
        public  byte bs[] = new byte[1024*64*40];
    }

    public static void fillHeap(int num) throws Exception{
        List<Obj> list = new ArrayList<>();
        for(int i=0;i<num;i++) {
            Thread.sleep(50);
            list.add(new Obj());
        }
        System.gc();
    }

    public static void main(String args[]) throws Exception {
        Thread.sleep(100000);
        fillHeap(10000);
        Thread.sleep(10000);
    }
}


