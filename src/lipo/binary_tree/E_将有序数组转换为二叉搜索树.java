package lipo.binary_tree;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0 , nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int rootIndex = (begin + end) >> 1;
        TreeNode left = buildTree(nums, begin, rootIndex - 1);
        TreeNode right = buildTree(nums, rootIndex + 1, end);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = left;
        root.right = right;
        return root;
    }

}
