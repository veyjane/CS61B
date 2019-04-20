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
        for(int i=1;i<length;i++){
            System.out.println(intArray[i] + "");
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

}
