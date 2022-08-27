package com.canseverayberk.leetcode.easy.dfstree;

/*
https://leetcode.com/problems/diameter-of-binary-tree
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        int diameterOfBinaryTree = diameterOfBinaryTree(node1);
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        int[] maxHeight = new int[] {0};
        traverse(root, maxHeight);
        return maxHeight[0];
    }

    private static void traverse(TreeNode root, int[] maxHeight) {
        if (root == null)
            return;
        diameter(root, 0, maxHeight);
        traverse(root.left, maxHeight);
        traverse(root.right, maxHeight);
    }

    public static int diameter(TreeNode root, int prevHeight, int[] maxHeight) {
        if (root == null)
            return prevHeight;

        if (root.left == null && root.right == null) {
            return prevHeight + 1;
        }

        int l = diameter(root.left, prevHeight, maxHeight);
        int r = diameter(root.right, prevHeight, maxHeight);

        maxHeight[0] = Math.max(maxHeight[0], l + r);
        return Math.max(l, r) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
