package test.basic.LinkedList;

import basic.LinkedList.SingleLinkedList;

public class testSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");

        singleLinkedList.display();
        singleLinkedList.delete("C");
        singleLinkedList.display();
        System.out.println(singleLinkedList.find("B"));
    }

}
