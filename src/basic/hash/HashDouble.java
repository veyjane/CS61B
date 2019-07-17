package basic.hash;

public class HashDouble {
    private DataItem[] hashArray; //DataItem类，表示每个数据项信息
    private int arraySize; //数组的初始大小
    private int nItem; //数组实际储存了多少数据
    private DataItem nonItem; //用于删除数据项

    public HashDouble(int arraySize){
        this.arraySize = 13;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); //删除的数据项下标为1
    }

    //判断数组是否存储满了
    public boolean isFull(){
        return (nItem == arraySize);
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return (nItem == 0);
    }

    public void display(){
        System.out.println("Table:");
        for (int j = 0; j < arraySize; j++){
            if (hashArray[j] != null){
                System.out.print(hashArray[j] + " ");
            }else {
                System.out.print("** ");
            }
        }
    }

    //通过哈希函数转换得到数组下标
    public int hashFunction1(int key){
        return key%arraySize;
    }

    public int hashFunction2(int key){
        return 5 - key%5;
    }

    //插入数据项
    public void insert(DataItem item){
        if (isFull()){
            System.out.println("哈希表已满，重新哈希化");
            extandHashTable();
        }
        int key = item.getKey();
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            hashVal = hashVal + stepSize;
            hashVal = hashVal%arraySize;
        }
        hashArray[hashVal] = item;
        nItem++;
    }

    /**
     * 重新哈希化
     * 数组有固定大小，扩展数组只能另外创建一个更大的数组，然后把旧数组中的数据插入到新数组中
     */
    public void extandHashTable(){
        int num = arraySize;
        nItem = 0; //重新计数，因为下面要把原来数组中的数据插入到新数组中
        arraySize *= 2; //数组大小翻倍
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for (int j = 0; j<arraySize; j++){
            insert(oldHashArray[j]);
        }
    }

    //删除数据项
    public DataItem delete(int key){
        if (isEmpty()){
            System.out.println("哈希表为空");
            return null;
        }
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while (hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                nItem--;
                return temp;
            }
            hashVal += stepSize;
            hashVal = hashVal%arraySize;
        }
        return null;
    }

    //查找数据项
    public DataItem find(int key){
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while (hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() != key){
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal = hashVal%arraySize;
        }
        return null;
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
