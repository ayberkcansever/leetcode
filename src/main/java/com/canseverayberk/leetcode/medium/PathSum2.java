package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

        prevList.add(root.val);
        targetSum -= root.val;

        if (root.left== null && root.right == null && targetSum == 0)
            list.add(prevList);

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
