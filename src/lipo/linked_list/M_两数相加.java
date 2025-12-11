package lipo.linked_list;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int sum = (flag ? 1 : 0);
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum -= 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;
        }
        if (flag) {
            p.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        M_两数相加 o = new M_两数相加();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(2, node2);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(5, node5);
        ListNode.printListNode(o.addTwoNumbers(node3, node6));

        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9, node7);
        ListNode node9 = new ListNode(9, node8);
        ListNode node10 = new ListNode(9, node9);
        ListNode node11 = new ListNode(9, node10);
        ListNode node12 = new ListNode(9, node11);
        ListNode node13 = new ListNode(9, node12);

        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9, node14);
        ListNode node16 = new ListNode(9, node15);
        ListNode node17 = new ListNode(9, node16);
        ListNode.printListNode(o.addTwoNumbers(node13, node17));
    }

}
