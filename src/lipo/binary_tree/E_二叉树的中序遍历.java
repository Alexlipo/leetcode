package lipo.binary_tree;

import lipo.linked_list.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }

    public List<Integer> inorderTraversal_Iteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal_Morris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode preocessor = null;
        while (root != null) {
            if (root.left != null) {
                preocessor = root.left;
                while (preocessor.right != null && preocessor.right != root) {
                    preocessor = preocessor.right;
                }
                if (preocessor.right == null) {
                    preocessor.right = root;
                    root = root.left;
                } else {
                    result.add(root.val);
                    preocessor.right = null;
                    root = root.right;
                }
            } else {
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
