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


        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        if (preorder.length == 1 && inorder.length == 1)
            return root;

        int[] left = getLeftSide(rootVal, inorder);
        int[] right = getRightSide(rootVal, inorder);

        root.right = buildTree(removeFrom(preorder, left, rootVal), right);
        root.left = buildTree(removeFrom(preorder, right, rootVal), left);

        return root;
    }

    public static int[] getLeftSide(int rootVal, int[] inorder) {
        List<Integer> list = new ArrayList<>();
        for(int i : inorder) {
            if (i == rootVal)
                break;
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getRightSide(int rootVal, int[] inorder) {
        List<Integer> list = new ArrayList<>();
        boolean foundRoot = false;
        for(int i : inorder) {
            if (i == rootVal)
                foundRoot = true;
            if (foundRoot)
                list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] removeFrom(int[] arr, int[] remove, int root) {
        Set<Integer> set = new HashSet<>();
        set.add(root);
        for(int i : remove) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
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
