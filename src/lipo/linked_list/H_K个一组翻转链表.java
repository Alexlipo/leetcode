package lipo.linked_list;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return temp.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }
        return temp.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
