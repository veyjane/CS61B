package test;

import basic.MyArray;
public class MyArrayTest {
    public static void main(String[] args){
        //实例化一个数组
        MyArray array = new MyArray(4);
        //添加4个元素
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        //显示数组
        array.display();

        System.out.println(array.get(0));

        array.delete(4);
        array.display();

        //换值
        array.modify(2,5);
        array.display();
    }
}
