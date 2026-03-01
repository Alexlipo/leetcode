package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 如果是叶子节点
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);

    }

}
