package basic.hash;

import basic.hash.SortLink.LinkNode;

//链地址法
public class HashChain {
    private SortLink[] hashArray; //数组中存放链表
    private int arraySize;
    public HashChain(int size){
        this.arraySize = size;
        hashArray = new SortLink[arraySize];
        //new出每个空列表初始化数组
        for (int i = 0; i < arraySize; i++){
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable(){
        for (int i = 0 ; i < arraySize ; i++){
            System.out.print(i+":");
            hashArray[i].display();
        }
    }

    public int hashFunction(int key) {
        return key%arraySize;
    }

    public void insert(LinkNode node){
        int key = node.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(node);
    }

    public LinkNode delete(int key){
        int hashVal = hashFunction(key);
        LinkNode temp = hashArray[hashVal].find(key);
        hashArray[hashVal].delete(key);
        return temp;
    }

    public LinkNode find(int key){
        int hashVal = hashFunction(key);
        LinkNode node = hashArray[hashVal].find(key);
        return node;
    }
}
