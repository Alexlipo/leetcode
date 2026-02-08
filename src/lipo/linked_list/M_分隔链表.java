package lipo.linked_list;

/**
 * https://leetcode.cn/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // 关键：防止形成环
        large.next = null;

        // 拼接两个链表
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}
