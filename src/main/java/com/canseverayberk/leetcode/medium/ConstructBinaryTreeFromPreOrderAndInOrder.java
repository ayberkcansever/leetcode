package com.canseverayberk.leetcode.medium;

import java.util.Arrays;
import java.util.Set;
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
        int myValue = preorder[0];
        TreeNode me = new TreeNode(myValue);
        int rootIndex = findRootIndex(inorder, myValue);

        int[] left = findLeft(inorder, rootIndex);
        int[] right = findRight(inorder, rootIndex);

        if (left.length == 0 && right.length == 0) {
            return me;
        }

        int[] newPreOrder = buildNewOrder(preorder, left);
        int[] newInOrder = buildNewOrder(inorder, left);

        if (newPreOrder.length > 0 && newInOrder.length > 0)
            me.left = buildTree(newPreOrder, newInOrder);

        newPreOrder = buildNewOrder(preorder, right);
        newInOrder = buildNewOrder(inorder, right);

        if (newPreOrder.length > 0 && newInOrder.length > 0)
            me.right = buildTree(newPreOrder, newInOrder);

        return me;
    }

    private static int[] buildNewOrder(int[] order, int[] newInOrder) {
        if(newInOrder.length == 0)
            return newInOrder;

        int[] newArray = new int[newInOrder.length];
        int j = 0;

        Set<Integer> inOrderSet = Arrays.stream(newInOrder).boxed().collect(Collectors.toSet());

        for (int k : order) {
            if (inOrderSet.contains(k)) {
                newArray[j++] = k;
            }
            if (j == newInOrder.length)
                break;
        }
        return newArray;
    }

    private static int[] findLeft(int[] array, int rootIndex) {
        int[] newArray = new int[rootIndex];
        System.arraycopy(array, 0, newArray, 0, rootIndex);
        return newArray;
    }

    private static int[] findRight(int[] array, int rootIndex) {
        int[] newArray = new int[array.length - rootIndex - 1];
        if (rootIndex >= 0)
            System.arraycopy(array, rootIndex + 1, newArray, 0, array.length - rootIndex - 1);
        return newArray;
    }

    private static int findRootIndex(int[] array, int rootValue) {
        int rootIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == rootValue) {
                rootIndex = i;
                break;
            }
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
