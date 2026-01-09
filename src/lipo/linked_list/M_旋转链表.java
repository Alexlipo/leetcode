package lipo.linked_list;

/**
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class M_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 1. 计算链表长度并找到尾节点
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        // 2. 处理 k 大于 n 的情况
        k %= n;
        if (k == 0) {
            return head;
        }
        // 3. 形成环
        tail.next = head;
        // 4. 找到新的尾节点（第 n-k 个）
        int step = n - k - 1;
        ListNode newTail = head;
        while (step-- > 0) {
            newTail = newTail.next;
        }
        // 5. 断开环
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        M_旋转链表 o = new M_旋转链表();
        ListNode.printListNode(o.rotateRight(ListNode.buildListNode(new int[]{1,2,3,4,5}), 2));
    }
}
