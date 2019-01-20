package tree;

/**
 * 这里的DEMO是二叉查找树
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(){}
    public BinaryTree(Node node) {
        root = new Node();
        //初始化根节点数据
        root.value = node.value;
        root.leftChild = null;
        root.rightChild = null;
    }

    /**
     * 功能描述:
     * 查找节点
     * @author: lanyangjia
     * @date: 2019/1/20
     * @param value
     * @return:
     **/
    public Node findKey(int value) {
        Node current = root;
        //从根节点开始遍历看是否有相等的值
        while (true) {
            if(current.value == value) {
                return current;
            } else if(current.value > value) {
                current = current.leftChild;
            } else if(current.value < value) {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }

    }

    /**
     * 功能描述: 
     * 插入一个节点
     * @author: lanyangjia
     * @date: 2019/1/20 
     * @param value  
     * @return: 
     **/
    public void insert(int value) {
        //如果树为空则初始化结点
        Node node = new Node();
        node.value = value;
        if(root == null) {
            root = node;
            return;
        }
        //找到自己合适的点插入
        Node p = root;//从根开始遍历，找到自己合适的位置
        while (p != null) {
            if(value > p.value) {
                if(p.rightChild == null) {
                    Node newNode = new Node(value);
                    p.rightChild = newNode;//新增节点
                    return;
                }
                p = p.rightChild;
            } else if(value < p.value) {
                if(p.leftChild == null) {
                    Node newNode = new Node(value);
                    p.leftChild = newNode;
                    return;
                }
                p = p.leftChild;
            } else {
                System.out.println("insert Error");
            }
        }

    }
    //删除结点
    //Todo

    //前序遍历
    public void preOrderTraverse() {
        preOrderTraverse(this.root);
    }
    public void preOrderTraverse(Node node) {
        if(node == null) return;
        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }


    //中序遍历
    public void inOrderTraverse() {
        inOrderTraverse(this.root);
    }
    public void inOrderTraverse(Node node) {
        if(node == null) return;
        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }

    //后序遍历
    public void postOrderTraverse(){
        postOrderTraverse(this.root);
    }
    public void postOrderTraverse(Node node) {
        if(node == null) return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }
    public static void main(String[] args) {
        Node node = new Node(13);
        BinaryTree binaryTree = new BinaryTree(node);//初始化树
        binaryTree.insert(10);
        binaryTree.insert(16);
        binaryTree.insert(9);
        binaryTree.insert(11);
        binaryTree.insert(14);
        binaryTree.preOrderTraverse();//前序遍历
        System.out.println("------------");
        binaryTree.inOrderTraverse();//中序遍历
        System.out.println("------------");
        binaryTree.postOrderTraverse();//后序遍历


    }
}
