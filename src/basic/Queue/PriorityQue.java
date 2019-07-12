package basic.Queue;

import com.sun.org.apache.xpath.internal.VariableStack;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class PriorityQue {
    private int maxSize;
    private int[] priQueArray;
    private int nItems;

    public PriorityQue(int s){
        maxSize = s;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    //插入数据
    public void insert(int value){
        int j;
        if(nItems==0){
            priQueArray[nItems++] = value;
        }else {
            j = nItems-1;
            //插入排序
            while (j >= 0 && value>priQueArray[j]){
                priQueArray[j+1]=priQueArray[j];
                j--;
            }
            priQueArray[j+1]=value;
            nItems++;
        }
    }

    //移除数据
    //被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为 -1
    public int remove(){
        int k = nItems-1;
        int value = priQueArray[k];
        priQueArray[k] = -1;//表示这个位置数据被移除
        return value;
    }

    //查看优先级最高的元素
    public int peekMin(){
        return priQueArray[nItems-1];
    }

    //判断是否为空
    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }
}
