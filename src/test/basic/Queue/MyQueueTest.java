package test.basic.Queue;

import basic.Queue.MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
        System.out.println(queue.remove());
    }
}
