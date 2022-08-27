package com.canseverayberk.leetcode.hard.dfstree;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum
 */
public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        int maxPathSum = maxPathSum(node1);
    }

    public static int maxPathSum(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        traverse(root, result);
        return result[0];
    }

    private static void traverse(TreeNode root, int[] result) {
        if (root == null) {
            return;
        }
        int[] max = new int[] {Integer.MIN_VALUE};
        sumFromNode(root, 0, max);
        result[0] = Math.max(result[0], max[0]);

        traverse(root.left, result);
        traverse(root.right, result);
    }

    private static int sumFromNode(TreeNode root, int prevSum, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            maxSum[0] = Math.max(maxSum[0], root.val);
            return root.val;
        }

        prevSum += root.val;
        maxSum[0] = Math.max(maxSum[0], prevSum);

        int l = Math.max(0, sumFromNode(root.left, prevSum, maxSum));
        int r = Math.max(0, sumFromNode(root.right, prevSum, maxSum));

        maxSum[0] = Math.max(maxSum[0], l + r + root.val);

        return Math.max(l, r) + root.val;
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
