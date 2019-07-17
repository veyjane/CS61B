package basic.hash;

public class MyhashTable {
    private DataItem[] hashArray; //DataItem类，表示每个数据项信息
    private int arraySize; //数组的初始大小
    private int nItem; //数组实际储存了多少数据
    private DataItem nonItem; //用于删除数据项

    public MyhashTable(int arraySize){
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); //删除的数据项下标为1
    }



    public boolean isEmpty(){
        return (nItem == arraySize);
    }

    public void display(){

    }

    public class DataItem{
        private int iData;
        public DataItem(int iData){
            this.iData = iData;
        }
        public int getKey(){
            return iData;
        }
    }
}
