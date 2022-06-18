package com.canseverayberk.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode6.left = treeNode2;
        treeNode6.right = treeNode8;
        treeNode2.left = treeNode0;
        treeNode2.right = treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;

        TreeNode lowestCommonAncestor = lowestCommonAncestor(treeNode6, treeNode2, treeNode4);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>[] paths = new List[2];
        paths[0] = new ArrayList<>();
        paths[1] = new ArrayList<>();
        traverse(root, p, q, paths);

        int index = Math.min(paths[0].size(), paths[1].size());

        TreeNode lca = null;
        for (int i = 0; i < index; i++) {
            if (paths[0].get(i) == paths[1].get(i))
                lca = paths[0].get(i);
        }

        return lca;
    }

    public static void traverse(TreeNode root, TreeNode p, TreeNode q, List<TreeNode>[] paths) {
        if (root == null)
            return;

        if (root.val == p.val) {
            paths[0].add(0, root);
        } else if (root.val == q.val) {
            paths[1].add(0, root);
        }

        traverse(root.left, p, q, paths);
        traverse(root.right, p, q, paths);

        if (root.left != null && paths[0].contains(root.left))
            paths[0].add(0, root);

        if (root.left != null && paths[1].contains(root.left))
            paths[1].add(0, root);

        if (root.right != null && paths[0].contains(root.right))
            paths[0].add(0, root);

        if (root.right != null && paths[1].contains(root.right))
            paths[1].add(0, root);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
