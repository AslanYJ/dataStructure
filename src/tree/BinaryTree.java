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
    /**
     * 功能描述: 
     * 删除节点，有三种情况，没有子节点，只有一个子节点，或者子节点下面还有节点
     * @author: lanyangjia
     * @date: 2019/1/21 
     * @param value  
     * @return: 
     **/
    public void delete(int value) {
        Node p = this.root;//要删除的节点，先从子节点开始
        Node pp = null;//要删除节点的父节点

        //先找到这个点
        while (p != null && p.value != value) {
            pp = p;
            if(p.value > value) p = p.rightChild;
            else p = p.leftChild;
        }
        if(p == null) return;//没找到

        //找到该节点，要判断节点的情况，对不同情况进行删除
        //要删除的节点有两个子节点,从右边中找最小的值，放在要删除节点位置
        if(p.leftChild != null && p.rightChild != null) {
            Node minP = p.rightChild;
            Node minPP = p;//表示minP的父节点
            while (minP.leftChild != null) {
                minPP = minP;
                minP = minP.leftChild;
            }
            p.value = minP.value;//将minP的数据交换到p中
            p = minP; //下面就变成了删除minP了
            pp = minPP;
        }

        //删除节点是一个节点或者只有一个子节点
        Node child;//p的子节点
        if(p.leftChild != null) child = p.leftChild;
        else if(p.rightChild != null) child = p.rightChild;
        else child = null;

        if(pp == null) root = child;//删除的根节点
        else if(pp.leftChild == p) pp.leftChild = child;
        else pp.rightChild = child;

    }

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

    public int depth() {
        return depth(this.root);
    }

    //递归计算树的深度
    public int depth(Node node) {
        //把问题分解，如果要计算出整个树的深度，其实就是比较Max(left,right) + 1;再分解问题为计算一个节点的问题，也是要先遍历左，然后遍历右，最后比较大小
        if(node == null) return -1;
        int left = depth(node.leftChild);
        int right = depth(node.rightChild);
        return Math.max(left,right) + 1;
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
        System.out.println(binaryTree.depth());

    }
}
