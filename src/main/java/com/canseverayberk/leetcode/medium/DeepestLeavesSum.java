package com.canseverayberk.leetcode.medium;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        _1.left = _2;
        TreeNode _3 = new TreeNode(3);
        _1.right = _3;
        TreeNode _4 = new TreeNode(4);
        _2.left = _4;
        TreeNode _5 = new TreeNode(5);
        _2.right = _5;
        TreeNode _6 = new TreeNode(6);
        _3.right = _6;
        TreeNode _7 = new TreeNode(7);
        _4.left = _7;
        TreeNode _8 = new TreeNode(8);
        _6.right = _8;

        int sum = deepestLeavesSum(_1);
    }

    public static int deepestLeavesSum(TreeNode root) {
        int maxLevel = maxLevel(root, 0, 0);
        return traverse(root, 0, maxLevel, 0);
    }

    private static int maxLevel(TreeNode node, int level, int maxLevel) {
        if (node == null) {
            return maxLevel;
        }
        level = level + 1;
        if (level > maxLevel) {
            maxLevel = level;
        }
        maxLevel = maxLevel(node.left, level, maxLevel);
        maxLevel = maxLevel(node.right, level, maxLevel);
        return maxLevel;
    }

    private static int traverse(TreeNode node, int level, int maxLevel, int sum) {
        if (node == null) {
            return sum;
        }
        level = level + 1;
        if (level == maxLevel) {
            sum += node.val;
        }
        sum = traverse(node.left, level, maxLevel, sum);
        sum = traverse(node.right, level, maxLevel, sum);
        return sum;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
