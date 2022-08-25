package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-right-side-view
 */
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
        if (root == null)
            return List.of();

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            TreeNode rightestNode = null;
            for (int i = 0; i < size; i++) {
                rightestNode = queue.poll();

                if (rightestNode.left != null)
                    queue.offer(rightestNode.left);
                if (rightestNode.right != null)
                    queue.offer(rightestNode.right);
            }

            list.add(rightestNode.val);
        }

        return list;
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
