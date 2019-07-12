package basic.Stack;

public class MyStack {
    private int[] array;
    private int top;
    private int maxSize;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据
    public void push(int value){
        if (top < maxSize-1){
            //top先自增，再计算
            array[++top] = value;
        }
    }

    //弹出栈顶元素
    public int pop(){
        return array[top--];
    }

    //访问栈顶元素
    public int peek(){
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }
}
