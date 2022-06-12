package com.canseverayberk.leetcode.medium;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        boolean validBST = isValidBST(node1);
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer minValueToCheck, Integer maxValueToCheck) {
        if (root == null) {
            return true;
        }

        if (minValueToCheck != null && root.val <= minValueToCheck) {
            return false;
        }

        if (maxValueToCheck != null && root.val >= maxValueToCheck) {
            return false;
        }

        return validate(root.left, minValueToCheck, root.val) && validate(root.right, root.val, maxValueToCheck);
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
