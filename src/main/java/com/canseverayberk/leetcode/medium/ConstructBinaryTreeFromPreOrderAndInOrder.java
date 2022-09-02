package com.canseverayberk.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreOrderAndInOrder {

    public static void main(String[] args) {
        int[] preOrder = new int[] {3,9,20,15,7};
        int[] inOrder = new int[] {9,3,15,20,7};

        TreeNode treeNode = buildTree(preOrder, inOrder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        int[] leftTree = getLeftTree(inorder, root.val);
        int[] rightTree = getRightTree(inorder, root.val);

        root.left = buildTree(removeTree(preorder, rightTree, root.val), leftTree);
        root.right = buildTree(removeTree(preorder, leftTree, root.val), rightTree);

        return root;
    }

    private static int[] removeTree(int[] preorder, int[] tree, int root) {
        Set<Integer> set = new HashSet<>();
        set.add(root);
        for(int i : tree) {
            set.add(i);
        }

        int length = preorder.length - 1 - tree.length;
        int[] remaining = new int[length];
        int j = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (!set.contains(preorder[i])) {
                remaining[j] = preorder[i];
                j++;
            }
        }
        return remaining;
    }

    private static int[] getLeftTree(int[] inorder, int rootVal) {
        int rootIndex = findRootIndex(inorder, rootVal);

        int[] leftTree = new int[rootIndex];
        for(int i = 0; i < rootIndex; i++) {
            leftTree[i] = inorder[i];
        }

        return leftTree;
    }

    private static int[] getRightTree(int[] inorder, int rootVal) {
        int rootIndex = findRootIndex(inorder, rootVal);

        int[] rightTree = new int[inorder.length - rootIndex - 1];
        for(int i = rootIndex + 1; i < inorder.length; i++) {
            rightTree[i - rootIndex - 1] = inorder[i];
        }

        return rightTree;
    }

    private static int findRootIndex(int[] inorder, int rootVal) {
        int rootIndex = 0;
        while(inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        return rootIndex;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
