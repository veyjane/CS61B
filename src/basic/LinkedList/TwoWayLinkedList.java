package basic.LinkedList;

public class TwoWayLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public class Node{
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data){
            this.data = data;
        }
    }

    public TwoWayLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addHead(Object value){
        Node node = new Node(value);
        if (size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
            size++;
        }
    }

    //在链表尾新增节点
    public void addTail(Object value){
        Node node = new Node(value);
        if (size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    //删除链表头
    public Node deleteHead(){
        Node temp = head;
        if (size != 0){
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }

    //删除链表尾
    public Node deleteTail(){
        Node temp = tail;
        if (size != 0){
            tail = tail.next;
            tail.next = null;
            size--;
        }
        return temp;
    }

    //获得链表节点数
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if (size > 0){
            Node node = head;
            int tempSize = size;
            if (tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.data+"]");
            }
            while (tempSize > 0){
                if (node.equals(head)){
                    System.out.print("["+node.data+"->");
                }else if (node.next == null){
                    System.out.print(node.data+"]");
                }else {
                    System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();

        }else {//如果一个节点都没有打印"[]"
            System.out.println("[]");
        }
    }

}
