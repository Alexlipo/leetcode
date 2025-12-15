package lipo.linked_list;

import java.util.*;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void printNode(Node node) {
        List<String> list = new ArrayList<>();
        Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        Node p = node;
        while (p != null) {
            map.put(p, i++);
            p = p.next;
        }
        p = node;
        while (p != null) {
            list.add(Arrays.toString(new Integer[]{p.val, p.random != null ? map.get(p.random) : null}));
            p = p.next;
        }
        System.out.println(list);
    }
}
