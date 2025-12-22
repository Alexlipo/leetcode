package lipo.binary_tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 root 是空，或就是 p 或 q，直接返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 在左子树中找 p 或 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中找 p 或 q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况1：左右都找到 → 当前 root 就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 情况2：只找到一个 → 把那个往上返回
        return left != null ? left : right;
    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

}
