package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_二叉树中的最大路径和 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // 左右子树贡献（负数直接丢弃）
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // 以当前节点为拐点的路径和
        int pathSum = left + right + node.val;

        // 更新全局最大值
        maxSum = Math.max(maxSum, pathSum);

        // 向父节点提供的单边最大路径
        return node.val + Math.max(left, right);
    }

}
