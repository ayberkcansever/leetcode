package com.canseverayberk.leetcode.medium.dfstree;

import com.canseverayberk.leetcode.easy.bfstree.MinimumDepthOfBinaryTree;

/*
https://leetcode.com/problems/path-sum-iii
 */
public class PathSumIII {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node5 = new TreeNode(5);

        node3.left = node9;
        node3.right = node5;
        node5.left = node15;
        node5.right = node4;

        int pathSum = pathSum(node3, 12);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int[] count = new int[]{0};
        traverse(root, targetSum, 0, count);
        return count[0];
    }

    public static void traverse(TreeNode root, int targetSum, long prevSum, int[] count) {
        if (root == null)
            return;
        count(root, targetSum, prevSum, count);
        traverse(root.left, targetSum, prevSum, count);
        traverse(root.right, targetSum, prevSum, count);
    }

    public static void count(TreeNode root, int targetSum, long prevSum, int[] count) {
        if (root == null)
            return;

        prevSum += root.val;
        if (prevSum == targetSum) {
            count[0]++;
        }

        count(root.left, targetSum, prevSum, count);
        count(root.right, targetSum, prevSum, count);
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
