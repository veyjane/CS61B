package basic.Sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] sourceArray){
        //这里的for循环表示总共需要多少轮
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //总共循环arr.length-1次
        for(int i=1;i<arr.length;i++){
            //设定一个标记，若为true，则表示此次循环没有进行交换，即待序列序列已经有序，排序已经完成
            boolean flag = true;
            for (int j=0;j<arr.length-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
                if (flag){
                    break;
                }
            }
        }
        return arr;
    }
}
