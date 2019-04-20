package basic;

public class MyArray {
    //定义一个数组
    private int [] intArray;
    //定义实际长度
    private  int elems;
    //定义数组长度
    private int length;

    //生成一个长度为50的数组
    public MyArray(){
        elems=0;
        length=50;
        intArray = new int[length];
    }

    public MyArray(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    //定义获取长度方法
    public  int getSize(){
        return elems;
    }

    /**
     * 遍历所有元素
     */
    public void display(){
        for(int i=0;i<elems;i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    /**
     *添加元素
     * @param value 添加值
     * @return 添加成功返回true，失败返回false
     * intArray[elems]刚好对应实际长度elems下一位
     */
    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    /**
     * 根据下标获取元素
     * @param i
     * @return 下标在有效范围内则返回下标所在元素
     */
    public int get(int i){
        if (i<=-1||i>=elems){
             System.out.println("访问下标越界");
        }
        return intArray[i];
    }

    /**
     * 查找元素
     * @param value
     * @return 查找的元素存在返回下标值，查找元素不存在返回-1
     */
    public int find(int value){
        int i; //i需要在循环外部声明
        for (i = 0;i < elems;i++){
            if (intArray[i]==value) break;
        }
        if(i==elems) return -1;
        return i;
    }

    /**
     *删除元素
     * @param value
     * @return 删除成功返回true,删除失败返回false
     */
    public boolean delete(int value){
        int k = find(value);
        if (k == -1){
            return false;
        }else {
            if(k == elems-1){
                elems--; //末尾直接删除
            }else {
                for (int i=k;i<elems;i++){ //下标从k到elems-1开始移动
                    intArray[i]=intArray[i+1];
                }
                elems--;
            }
            return true;
        }
    }

    /**
     * 修改数据
     * @param oldValue 原值
     * @param newValue 新值
     * @return 修改成功返回true，修改失败返回false
     */
    public boolean modify(int oldValue, int newValue){
        int k = find(oldValue);
        if(k == -1){
            System.out.println("需要修改的数据不存在");
            return  false;
        }else{
            intArray[k]=newValue;
        }
        return true;
    }
}
