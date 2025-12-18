package lipo.binary_tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_二叉树的直径 {

    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depth(root);
        return result - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree_iteration(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                node = stack.pop();
                int leftDepth = node.left != null ? map.get(node.left) : 0;
                int rightDepth = node.right != null ? map.get(node.right) : 0;
                map.put(node, Math.max(leftDepth, rightDepth) + 1);
                res = Math.max(res, leftDepth + rightDepth);
            }
        }
        return res;
    }
}
