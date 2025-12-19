package lipo.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_路径总和III {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L, 1);
        return dfs(root, preSum, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> preSum, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int sum = preSum.getOrDefault(curr - targetSum, 0);
        preSum.put(curr, preSum.getOrDefault(curr, 0) + 1);
        sum += dfs(root.left, preSum, curr, targetSum);
        sum += dfs(root.right, preSum, curr, targetSum);
        preSum.put(curr, preSum.getOrDefault(curr, 0) - 1);
        return sum;
    }

}
