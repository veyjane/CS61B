package basic.LinkedList;

//双端链表实现队列
public class QueueLinkedList {
    private DoublePointLinkedList dp;

    public  QueueLinkedList(){
        DoublePointLinkedList dp = new DoublePointLinkedList();
    }

    public void insert(Object obj){
        dp.addTail(obj);
    }

    public void delete(Object obj){
        dp.deleteHead();
    }

    public boolean isEmpty(){
        return dp.isEmpty();
    }

    public int getSize(){
        return dp.getSize();
    }

    public void display(){
        dp.display();
    }

}
