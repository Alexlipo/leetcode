package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            // 下一层虚拟头
            Node dummy = new Node();
            // 下一层尾指针
            Node tail = dummy;
            // 遍历当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            // 进入下一层
            cur = dummy.next;
        }
        return root;
    }

}
