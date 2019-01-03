package linklist;

/**
 * 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        //利用快慢指针找到中位数
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //慢指针指向的就是中间的节点,将中间的节点指向的值全部逆向
        slow = reverse(slow.next);//最后一个点
        //遍历两个链表，看看是否相等
        while (slow != null) {
            if(head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
