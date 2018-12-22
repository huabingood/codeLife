package algorithm.quicksort;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args){
        int[] arry = {6,1,2,7,9,3,4,5,10,8};
        sort(arry,0,arry.length-1);
        Arrays.stream(arry).forEach(e->System.out.println(e));

    }

    public static int partition(int[] arry,int start,int end){
        // 获取基准值
        int key = arry[start];
        // 在起始下标小于结束下标的情况下
        while(start<end){
            // 如果数组右边的比基准值大，就一直循环下去
            while(arry[end]>=key && end>start){
                end--;
            }
            // 如果数组右边的值比小于或等于基准值，就将右边的值放到左边
            arry[start] = arry[end];
            // 从左边开始遍历，如果比基准值小，就一直循环下去
            while(arry[start]<=key && end>start){
                start++;
            }
            arry[end]=arry[start];
        }
        arry[end]=key;
        return end;
    }

    public static void sort(int[] arry,int start,int end){
        if(start>=end){
            return;
        }
        int index = partition(arry,start,end);
        sort(arry,start,index-1);
        sort(arry,index+1,end);
    }


}
