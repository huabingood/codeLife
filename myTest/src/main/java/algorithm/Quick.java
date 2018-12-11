package algorithm;

public class Quick {
    public static void main(String[] args){
        Integer[] arrs = {6,1,2,7,9,3,4,5,10,8};

        quickSort(arrs,0,arrs.length-1);

        System.out.println(arrs);
    }

    public static void quickSort(Integer[] arrs,int left,int right){
        int i,j,t,temp;
        if(left>=right){
            return;
        }

        i = left;
        j = right;
        temp = arrs[i];

        while(i!=j){
            while(i<j && arrs[j]>=temp){
                j--;
            }
            while(i<j && arrs[i]<=temp){
                i--;
            }

            if(i<j){
                t = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = t;
            }
        }
        arrs[left]= arrs[i];
        arrs[i] = temp;

        quickSort(arrs,left,i-1);
        quickSort(arrs,i+1,right);
    }

}
