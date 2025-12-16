package lipo.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_LRU缓存 {

    class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int cap;
        private Map<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int cap) {
            this.cap = cap;
            this.map = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int val) {
            Node node = map.get(key);
            if (node != null) {
                node.value = val;
                moveToHead(node);
            } else {
                if (map.size() == cap) {
                    Node lru = tail.prev;
                    removeNode(lru);
                    map.remove(lru.key);
                }
                Node newNode = new Node(key, val);
                addHead(newNode);
                map.put(key, newNode);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addHead(node);
        }

        private void addHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

}
