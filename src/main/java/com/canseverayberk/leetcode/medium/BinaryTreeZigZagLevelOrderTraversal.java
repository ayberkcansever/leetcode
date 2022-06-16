package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {

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

        List<List<Integer>> levelOrder = zigzagLevelOrder(node3);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> orderNodeList = new ArrayList<>();
        traverse(root, orderNodeList, -1);
        return orderNodeList;
    }

    public static void traverse(TreeNode root, List<List<Integer>> orderNodeList, int preOrder) {

        if (root == null) {
            return;
        }

        if (orderNodeList.size() == preOrder + 1) {
            List<Integer> currentList = new ArrayList<>();
            orderNodeList.add(currentList);
        }

        int currentOrder = preOrder + 1;
        List<Integer> currentList = orderNodeList.get(currentOrder);
        if (currentList == null)
            currentList = new ArrayList<>();

        if (currentOrder % 2 == 1) {
            currentList.add(0, root.val);
        } else {
            currentList.add(currentList.size(), root.val);
        }

        traverse(root.left, orderNodeList, currentOrder);
        traverse(root.right, orderNodeList, currentOrder);
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
