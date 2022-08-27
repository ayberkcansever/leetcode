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

    static int maxPathSum(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        traverse(root, result);
        return result[0];
    }

    static int traverse(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int current = root.val;
        int left = traverse(root.left, max);
        int right = traverse(root.right, max);

        if (left > 0) {
            current += left;
        }
        if (right > 0) {
            current += right;
        }

        max[0] = Math.max(max[0], current);
        int nowMax = Math.max(root.val + left, root.val + right);
        return Math.max(nowMax, root.val);
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
