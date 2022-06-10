package com.canseverayberk.leetcode.easy;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode5;

        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);
        TreeNode treeNode_4 = new TreeNode(4);
        TreeNode treeNode_7 = new TreeNode(7);

        treeNode_2.left = treeNode_1;
        treeNode_2.right = treeNode_3;

        treeNode_1.right = treeNode_4;

        treeNode_3.right = treeNode_7;

        TreeNode mergedTree = mergeTrees(treeNode1, treeNode_2);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
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
