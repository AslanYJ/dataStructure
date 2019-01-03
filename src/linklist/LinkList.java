package linklist;

/**
 * 功能描述: 
 * 链表的基础，增删改查
 * @Author: lanyangjia
 * @Date: 2019/1/3 12:22
 * 
 */
public class LinkList {
    private Node head;
    public static void main(String[] args) {
        LinkList linkListDemo = new LinkList();
        linkListDemo.addNode(new Node<>("1"));
        linkListDemo.addNode(new Node<>("2"));
        linkListDemo.addNode(new Node<>("3"));
        linkListDemo.printList();
        linkListDemo.deleteNode(3);
        linkListDemo.printList();
        linkListDemo.addNode(new Node<>("4"));
        linkListDemo.printList();


    }

    public LinkList() {
        //初始化的时候新建一个带头链表（哨兵机制）
        head = new Node<>(null);

    }

    //新增节点,直接加到末尾
    public void addNode(Node node) {
        Node temp = head;//从头开始遍历
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;//指向下一个节点
    }

    //指定位置新增节点
    public void addNode(Node node,int k) {
        if(k < 1 || k > length() + 1) {
            System.out.println("插入的位置不合法");
            return;
        }
        int index = 0;
        Node temp = head;//从头开始遍历
        while (temp.next != null) {
            ++index;
            if(index == k) {
                node.next = temp.next;//要插入的节点指向上一个指定的节点
                temp.next = node;//指向要插入的节点
                break;
            }
            temp = temp.next;
        }
    }

    //删除指定位置的节点
    public void deleteNode(int k) {
        if(k < 1 || k > length()) {
            System.out.println("删除的位置不合法");
            return;
        }
        int index = 1;
        Node temp = head.next;
        while(temp != null) {
            ++index;
            if(index == k) {
                if(temp.next == null) {
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
            }
            temp = temp.next;
        }
    }

    //修改



    //遍历
    public void printList() {
        Node temp = head;//从头开始遍历
        if(head.next == null) {
            System.out.println("该链表暂时没有数据哦");
        }
        while (temp.next != null) {
            System.out.println(temp.next.data);
            temp = temp.next;
        }
    }


    //链表长度
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        return length;
    }






}
