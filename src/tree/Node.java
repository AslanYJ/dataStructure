package tree;

/**
 * 二叉树的树结点
 */
public class Node {
    public  int value;
    public Node leftChild;//左结点
    public Node rightChild;//右结点

    public void display() {
        System.out.print(this.value + " ");
    }

    public Node(int value) {
        this.value = value;
    }
    public Node() {
    }
}
