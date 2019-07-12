package basic.LinkedList;

//单向链表
public class SingleLinkedList {
    private int size;//链表节点个数
    private Node head;//头节点

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //链表的每个节点类
    public class Node{
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的链接
        public Node(Object data){
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if (size == 0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回Node，找不到返回null
    public Node find(Object obj) {
        Node current = head;
        int tmpSize = size;
        while (tmpSize > 0) {
            if (obj==current.data) {
                return current;
            } else {
                current = current.next;
                tmpSize--;
            }
        }
        return null;
    }

    //删除指定的元素，删除成功了返回true
    public boolean delete(Object value){
        if (size == 0){
            return false;
        }
        Node previous = head;
        Node current = head;
        while (current.data!=value){
            if (current.next==null){
                return false;
            }else {
                previous = current;
                current = current.next;
            }
            //如果删除的是第一个节点
            if (current==head){
                head = current.next;
                size--;
            }else {//如果删除的不是第一个节点
                previous.next = current.next;
                size--;
            }
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        System.out.println("List (head-->last):");
        if (size>0) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "");
                current = current.next;
            }
            return;
        }else {
            System.out.println("No Node");
        }
    }
}

