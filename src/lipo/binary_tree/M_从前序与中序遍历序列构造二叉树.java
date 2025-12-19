package lipo.binary_tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> map) {
        if (pLeft > pRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        int rootIndex = map.get(preorder[pLeft]);
        int leftSize = rootIndex - iLeft;
        root.left = buildTree(preorder, pLeft + 1, pLeft + leftSize, inorder, iLeft, rootIndex - 1, map);
        root.right = buildTree(preorder, pLeft + leftSize + 1, pRight, inorder, rootIndex + 1, iRight, map);
        return root;
    }

    public TreeNode buildTree_iteration(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int index = 0;
        for (int i = 1; i < preorder.length; i++) {
            int pVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[index]) {
                node.left = new TreeNode(pVal);
                index++;
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    node = stack.pop();
                    index++;
                }
                node.right = new TreeNode(pVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
