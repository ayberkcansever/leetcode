package com.canseverayberk.leetcode.easy.dfstree;

/*
https://leetcode.com/problems/path-sum
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        node5.left = node4;
        node5.right = node8;

        boolean hasPathSum = hasPathSum(node5, 13);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        return traverse(root, 0, targetSum);
    }

    private static boolean traverse(TreeNode root, int prevSum, int target) {
        if (root == null) {
            return false;
        }

        prevSum += root.val;
        if (root.left == null && root.right == null && prevSum == target) {
            System.out.println(prevSum);
            return true;
        }

        boolean l = traverse(root.left, prevSum, target);
        boolean r = traverse(root.right, prevSum, target);
        return l || r;
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
