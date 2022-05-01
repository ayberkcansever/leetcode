package com.canseverayberk.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        treeNode1.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(1);
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(6);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(2);
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(0);
        treeNode3.left = treeNode6;
        TreeNode treeNode7 = new TreeNode(8);
        treeNode3.right = treeNode7;
        TreeNode treeNode8 = new TreeNode(7);
        treeNode5.left = treeNode8;
        TreeNode treeNode9 = new TreeNode(4);
        treeNode5.right = treeNode9;

        TreeNode lowestCommonAncestor = lowestCommonAncestor(treeNode1, treeNode2, treeNode9);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ancestorsP = new LinkedList<>();
        LinkedList<TreeNode> ancestorsQ = new LinkedList<>();
        traverse(root, p.val, q.val, new LinkedList<>(), ancestorsP, ancestorsQ);
        List<TreeNode> intersectionAncestors;
        if (ancestorsP.size() > ancestorsQ.size()) {
            intersectionAncestors = ancestorsP.stream().filter(ancestorsQ::contains).collect(Collectors.toList());
        } else {
            intersectionAncestors = ancestorsQ.stream().filter(ancestorsP::contains).collect(Collectors.toList());
        }
        return intersectionAncestors.get(intersectionAncestors.size() - 1);
    }

    static void traverse(TreeNode node, int pVal, int qVal,
                         LinkedList<TreeNode> allAncestors,
                         LinkedList<TreeNode> ancestorsP,
                         LinkedList<TreeNode> ancestorsQ) {
        if (node == null) {
            return;
        }
        if (node.val == pVal) {
            ancestorsP.addAll(allAncestors);
            ancestorsP.add(node);
        }
        if (node.val == qVal) {
            ancestorsQ.addAll(allAncestors);
            ancestorsQ.add(node);
        }
        allAncestors.add(node);
        traverse(node.left, pVal, qVal, allAncestors, ancestorsP, ancestorsQ);
        traverse(node.right, pVal, qVal, allAncestors, ancestorsP, ancestorsQ);
        allAncestors.removeLast();
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
