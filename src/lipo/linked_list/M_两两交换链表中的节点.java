package lipo.linked_list;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead;
        while (p.next != null && p.next.next != null) {
            ListNode temp = p.next;
            p.next = temp.next;
            temp.next = temp.next.next;
            p.next.next = temp;
            p = temp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        M_两两交换链表中的节点 o = new M_两两交换链表中的节点();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode.printListNode(o.swapPairs(node4));
    }

}
