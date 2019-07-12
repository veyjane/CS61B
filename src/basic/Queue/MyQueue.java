package basic.Queue;

public class MyQueue {
    private Object[] queArray;
    //队列总大小
    private  int maxSize;
    //前端
    private int front;
    //后端
    private int rear;
    //队列中项目实际数目
    private int nItems;

    public MyQueue(int s){
        maxSize = s;
        queArray = new Object[s];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //队列中新增数据
    public void insert(int value){
        if (isFull()){
            System.out.println("队列已满");
        }else {
            //如果队列尾部指向顶了，循环回来，执行队列的第一个元素
            if (rear == maxSize-1){
                rear = -1;
            }
            //rear指针加一，在此处加入新增元素
            queArray[++rear] = value;
            nItems++;
        }
    }

    //移除数据
    public Object remove(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            Object removeValue = queArray[front];
            queArray[front] = null;
            front++;
            //如果头部指针到顶，循环回来到队列第一个元素
            if (front == maxSize){
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return null;
    }

    //查看头部数据
    public Object peekFront(){
        return queArray[front];
    }

    //判断队列是否满了
    public boolean isFull(){
        return (nItems == maxSize);
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return (nItems == 0);
    }

    //返回队列的大小
    public int getSize(){
        return maxSize;
    }

}
