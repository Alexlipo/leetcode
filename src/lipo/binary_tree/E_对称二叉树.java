package lipo.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        Queue<TreeNode> rightQueue = new LinkedList<>();
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left != null) {
                leftQueue.offer(left.left);
                leftQueue.offer(left.right);
            } else {
                return false;
            }
            if (right != null) {
                rightQueue.offer(right.right);
                rightQueue.offer(right.left);
            } else {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
        }
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }

    public boolean isSymmetric_recursion(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }



}
