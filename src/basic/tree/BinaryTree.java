package basic.tree;

public class BinaryTree implements Tree {

    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {//当前值比查找值大，搜寻左子树
                current = current.leftChild;
            } else if (current.data < key) {//当前值比查找值小，搜寻右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current; //parentNode存储最后一个不是null的节点
                if (current.data > data) {
                    current = current.leftChild;
                    if (current == null) {//左子节点为空，直接将新值插入该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {//右子节点为空，直接将新值插入该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.println(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.println(current.data + " ");
        }
    }

    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;
        //查找删除值，查不到返回false
        while (current.data != key) {
            parent = current;//parent保存要删除的节点
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        //如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        //当前节点只有一个节点
        if (current.leftChild == null && current.rightChild != null) {
            if (current == root) {
                root = current.rightChild;
            }
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.leftChild != null && current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            }
            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else {
            //当前存在两个节点
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }
            if (isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
