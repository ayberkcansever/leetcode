package com.canseverayberk.leetcode.easy;

public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node4;
        node3.right = node5;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node4.left = node1;
        node4.right = node2;

        TreeNode node4Sub = new TreeNode(4);
        TreeNode node1Sub = new TreeNode(1);
        TreeNode node2Sub = new TreeNode(2);
        node4Sub.left = node1Sub;
        node4Sub.right = node2Sub;

        boolean subtree = isSubtree(node3, node4Sub);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return subRoot == root;

        return root.val == subRoot.val && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
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
