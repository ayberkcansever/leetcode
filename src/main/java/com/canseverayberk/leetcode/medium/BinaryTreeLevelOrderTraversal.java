package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> levelOrder = levelOrder(node3);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> levelMap = new ArrayList<>();
        traverse(root, 0, levelMap);
        return levelMap;
    }

    public static void traverse(TreeNode root, int level, List<List<Integer>> levelMap) {
        if (root == null)
            return;

        level = level + 1;
        List<Integer> levelNodeList;
        if (levelMap.size() < level) {
            levelNodeList = new ArrayList<>();
        } else {
            levelNodeList = levelMap.get(level - 1);
        }

        levelNodeList.add(root.val);
        if (levelMap.size() > level - 1)
            levelMap.remove(level - 1);
        levelMap.add(level - 1, levelNodeList);

        traverse(root.left, level, levelMap);
        traverse(root.right, level, levelMap);
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
