package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_求根节点到叶节点数字之和 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 10 + node.val;

        // 叶子节点
        if (node.left == null && node.right == null) {
            return current;
        }

        return dfs(node.left, current) + dfs(node.right, current);
    }

}
