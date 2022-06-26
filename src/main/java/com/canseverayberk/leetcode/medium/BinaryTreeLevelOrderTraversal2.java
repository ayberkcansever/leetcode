package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversal2 {

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

        List<List<Integer>> levelOrder = levelOrderBottom(node3);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> orderMap = new HashMap<>();
        traverse(root, orderMap, -1);

        int totalOrderCount = orderMap.keySet().size();
        for (int order = totalOrderCount - 1; order >= 0; order--) {
            list.add(orderMap.get(order));

        }

        return list;
    }

    public static void traverse(TreeNode root, Map<Integer, List<Integer>> orderMap, int prevOrder) {
        if (root == null)
            return;

        int currentOrder = prevOrder + 1;
        List<Integer> nodes = orderMap.get(currentOrder);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(root.val);
        orderMap.put(currentOrder, nodes);

        traverse(root.left, orderMap, currentOrder);
        traverse(root.right, orderMap, currentOrder);
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
