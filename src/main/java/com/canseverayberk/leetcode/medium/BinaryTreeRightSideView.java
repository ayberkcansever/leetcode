package com.canseverayberk.leetcode.medium;

import java.util.*;

public class BinaryTreeRightSideView {

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

        List<Integer> rightSideView = rightSideView(node3);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        traverse(root, 0, list, -1);

        System.out.println(list);

        List<Integer> rightList = new ArrayList<>();
        for (Map<Integer, Integer> powerMap : list) {
            int maxValueInMap=(Collections.max(powerMap.values()));
            for (Map.Entry<Integer, Integer> entry : powerMap.entrySet()) {
                if (entry.getValue()==maxValueInMap) {
                    rightList.add(entry.getKey());
                    break;
                }
            }
        }

        return rightList;
    }

    public static void traverse(TreeNode root, int power, List<Map<Integer, Integer>> orderPowerList, int preOrder) {

        if (root == null) {
            return;
        }

        if (orderPowerList.size() == preOrder + 1) {
            orderPowerList.add(new TreeMap<Integer, Integer>());
        }


        int currentOrder = preOrder + 1;
        Map<Integer, Integer> currentOrderPowerMap = orderPowerList.get(currentOrder);
        if (currentOrderPowerMap == null) {
            currentOrderPowerMap = new TreeMap<>();
            currentOrderPowerMap.put(root.val, power + 1);
        } else {
            Integer currentPower = currentOrderPowerMap.get(root.val);
            if (currentPower == null) {
                currentPower = power + 1;
            } else {
                currentPower += 1;
            }
            currentOrderPowerMap.put(root.val, currentPower);
        }

        traverse(root.left, (currentOrderPowerMap.get(root.val) - 1) * 2, orderPowerList, currentOrder);
        traverse(root.right, (currentOrderPowerMap.get(root.val)) * 2, orderPowerList, currentOrder);
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
