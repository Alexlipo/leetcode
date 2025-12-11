package lipo.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_环形链表_II {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hash = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (hash.contains(node)) {
                return node;
            }
            hash.add(node);
            node = node.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;
    }

}
