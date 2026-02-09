package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
