package basic.Sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //总共经过N-1轮比较
        for (int i = 0;i<arr.length-1;i++) {
            int min = i;
            //每轮需要比较次数N-i
            for (int j = i;j < arr.length;j++) {
                if (arr[j] < arr[min]) {
                    //记录目前能找到的最小元素的下标
                    min = j;
                }
                //将找到的最小值的和i位置所在进行交换
                if (min != i) {
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }
            }
        }
        return arr;
    }
}
