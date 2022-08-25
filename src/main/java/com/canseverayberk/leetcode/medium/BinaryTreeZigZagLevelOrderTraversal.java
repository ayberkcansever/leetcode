package com.canseverayberk.leetcode.medium;

import java.util.*;
/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 */
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
        if(root == null)
            return List.of();

        List<List<Integer>> orderNodeList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (orderNodeList.size() % 2 == 1) {
                Collections.reverse(levelNodes);
            }
            orderNodeList.add(levelNodes);

        }

        return orderNodeList;
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
