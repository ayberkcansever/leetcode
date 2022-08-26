package com.canseverayberk.leetcode.medium.dfstree;

/*
https://leetcode.com/problems/sum-root-to-leaf-numbers
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        node5.left = node4;
        node5.right = node8;

        int sumNumbers = sumNumbers(node5);
    }

    public static int sumNumbers(TreeNode root) {
        int[] sum = new int[]{0};
        traverse(root, "0", sum);
        return sum[0];
    }

    public static void traverse(TreeNode root, String prevNumber, int[] sum) {
        if(root == null)
            return;

        prevNumber = prevNumber.concat(String.valueOf(root.val));
        int pathSum = Integer.parseInt(prevNumber);
        if (root.left == null && root.right == null) {
            sum[0] += pathSum;
        }

        traverse(root.left, prevNumber, sum);
        traverse(root.right, prevNumber, sum);
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
