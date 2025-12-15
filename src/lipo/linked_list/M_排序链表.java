package lipo.linked_list;

/**
 * https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        for (int subLen = 1; subLen < len; subLen *= 2) {
            ListNode prev = temp;
            ListNode p = temp.next;
            while (p != null) {
                ListNode head1 = p;
                for (int i = 1; i < subLen && p.next != null; i++) {
                    p = p.next;
                }
                ListNode head2 = p.next;
                p.next = null;
                p = head2;
                for (int i = 1; i < subLen && p != null && p.next != null; i++) {
                    p = p.next;
                }
                ListNode next = null;
                if (p != null) {
                    next = p.next;
                    p.next = null;
                }
                ListNode mergeHead = merge(head1, head2);
                prev.next = mergeHead;
                while (prev.next != null) {
                    prev = prev.next;
                }
                p = next;
            }
        }
        return temp.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode p = head;
        ListNode l1 = head1;
        ListNode l2 = head2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head.next;
    }

}
