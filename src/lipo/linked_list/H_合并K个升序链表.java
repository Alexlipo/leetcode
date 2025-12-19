package lipo.linked_list;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_合并K个升序链表 {
    class Node implements Comparable<Node> {
        int val;
        ListNode node;

        Node(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Node n) {
            return this.val - n.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Node(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            tail.next = n.node;
            tail = tail.next;
            if (n.node.next != null) {
                queue.offer(new Node(n.node.next.val, n.node.next));
            }
        }
        return head.next;
    }

}
