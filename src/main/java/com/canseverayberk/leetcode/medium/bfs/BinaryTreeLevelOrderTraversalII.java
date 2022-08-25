package com.canseverayberk.leetcode.medium.bfs;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 */
public class BinaryTreeLevelOrderTraversalII {

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
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        Stack<List<Integer>> levelNodesStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levelNodesStack.push(levelNodes);
        }

        while(!levelNodesStack.isEmpty()) {
            list.add(levelNodesStack.pop());
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
