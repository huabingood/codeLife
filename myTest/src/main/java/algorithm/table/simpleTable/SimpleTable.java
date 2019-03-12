package algorithm.table.simpleTable;

import java.util.ArrayList;

public class SimpleTable {
    private int size=10;
    private int[] myTable;

    public SimpleTable(){}
    public SimpleTable(int size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 初始化数组
     */
    public void initialArray(){
        myTable = new int[size];
    }

    /**
     * 根据数组的长度动态扩容，每次扩充两倍
     * 这个是重点
     */
    public void autoIncrementXapacity(){
        int[] newArr = new int[myTable.length*2];
        for(int i :myTable){
            newArr[i]=myTable[i];
        }
        myTable=newArr;
    }

    /**
     * 将数据打印出来
     */
    public void printList(){
        System.out.print("{");
        for(int i=0;i<myTable.length;i++){
            if(i==myTable.length-1){
                System.out.print(myTable[i]);
            }
            System.out.print(myTable[i]+",");
        }
        System.out.print("}");
    }


}
