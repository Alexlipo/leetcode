package lipo.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                nodeList.add(node);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).right = nodeList.get(i + 1);
            nodeList.get(i).left = null;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        TreeNode pre = null;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = node;
            }
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
            pre = node;
        }
    }

    public void flatten3(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode next = node.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node.right;
                node.right = next;
                node.left = null;
            }
            node = node.right;
        }
    }

}
