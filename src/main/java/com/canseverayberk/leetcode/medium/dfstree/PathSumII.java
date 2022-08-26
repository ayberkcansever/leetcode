package com.canseverayberk.leetcode.medium.dfstree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/path-sum-ii
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        node5.left = node4;
        node5.right = node8;

        List<List<Integer>> paths = pathSum(node5, 13);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return List.of();

        List<List<Integer>> list = new ArrayList<>();
        traverse(root, targetSum, new ArrayList<>(), list);
        return list;
    }

    public static void traverse(TreeNode root, int targetSum, List<Integer> prevList, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        int prevSum = root.val;
        for(int val : prevList) {
            prevSum += val;
        }

        prevList.add(root.val);
        if (root.left == null && root.right == null && prevSum == targetSum) {
            list.add(new ArrayList<>(prevList));
        }

        traverse(root.left, targetSum, new ArrayList<>(prevList), list);
        traverse(root.right, targetSum, new ArrayList<>(prevList), list);
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
