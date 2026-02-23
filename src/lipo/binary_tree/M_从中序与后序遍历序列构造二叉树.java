package lipo.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_从中序与后序遍历序列构造二叉树 {

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1, postorder);
    }

    private TreeNode buildTree(int iStart, int iEnd, int pStart, int pEnd, int[] postorder) {
        if (iStart > iEnd) {
            return null;
        }
        // 1️ 根节点
        TreeNode root = new TreeNode(postorder[pEnd]);
        // 2️ 找到中序中的位置
        int rootIndex = map.get(postorder[pEnd]);
        // 3️ 左子树大小
        int leftSize = rootIndex - iStart;
        // 4️ 构造左子树
        root.left = buildTree(iStart, rootIndex - 1, pStart, pStart + leftSize - 1, postorder);
        // 5️ 构造右子树
        root.right = buildTree(rootIndex + 1, iEnd, pStart + leftSize, pEnd - 1, postorder);
        return root;
    }
}
