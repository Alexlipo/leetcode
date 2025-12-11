package lipo.linked_list;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            ListNode next = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = next;
        }
        if (p2 == null) {
            //偶数个节点
            p2 = p1;
        } else {
            //奇数个节点
            p2 = p1.next;
        }
        p1 = prev;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        E_回文链表 o = new E_回文链表();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1, node1);
        System.out.println(o.isPalindrome(node2));

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(2, node4);
        ListNode node6 = new ListNode(1, node5);
        System.out.println(o.isPalindrome(node6));
    }
}
