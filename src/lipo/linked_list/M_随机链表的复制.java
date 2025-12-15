package lipo.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/889166/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_随机链表的复制 {

    Map<Node, Node> map = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        Node newHead = head.next;
        p = head;
        while (p != null) {
            Node node = p.next;
            p.next = p.next.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            p = p.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        M_随机链表的复制 o = new M_随机链表的复制();
        Node node1 = new Node(1);
        Node node2 = new Node(10);
        node2.next = node1;
        Node node3 = new Node(11);
        node3.next = node2;
        Node node4 = new Node(13);
        node4.next = node3;
        Node node5 = new Node(7);
        node5.next = node4;
        node4.random = node5;
        node3.random = node1;
        node2.random = node3;
        node1.random = node5;
        Node.printNode(o.copyRandomList2(node5));
    }

}
