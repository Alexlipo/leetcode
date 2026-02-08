package lipo.linked_list;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            // 如果发现重复
            if (cur.next != null && cur.val == cur.next.val) {
                // 跳过所有相同的值
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 删除整段
                pre.next = cur.next;
            } else {
                // 当前值安全，保留
                pre = pre.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
