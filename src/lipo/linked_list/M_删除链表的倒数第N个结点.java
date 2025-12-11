package lipo.linked_list;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while (n-- > 0) {
            p = p.next;
        }

        ListNode temp = new ListNode();
        temp.next = head;
        ListNode node = temp;
        while (p != null) {
            p = p.next;
            node = node.next;
        }
        node.next = node.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        M_删除链表的倒数第N个结点 o = new M_删除链表的倒数第N个结点();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        ListNode.printListNode(o.removeNthFromEnd(node5, 2));
    }

}
