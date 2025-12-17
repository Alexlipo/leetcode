package lipo.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree_width(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                TreeNode left = null;
                TreeNode right = null;
                if (node.left != null) {
                    left = node.left;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    right = node.right;
                    queue.offer(node.right);
                }
                node.left = right;
                node.right = left;
            }
        }
        return root;
    }
}
