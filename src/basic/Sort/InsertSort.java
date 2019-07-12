package basic.Sort;

import java.util.Arrays;

public class InsertSort {
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认有序
        for (int i =1;i<arr.length;i++) {
            //记录要插入的数据
            int temp = arr[i];
            int j = i;
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            //依次向后挪
            while (j > 0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }

            //存在比其小的数，插入
            if (i!=j){
                arr[i] = temp;
            }
        }
        return arr;
    }
}
