package com.canseverayberk.leetcode.medium;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class SumEvenValuedGrandparent {

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(6);
        TreeNode _2 = new TreeNode(7);
        _1.left = _2;
        TreeNode _3 = new TreeNode(8);
        _1.right = _3;
        TreeNode _4 = new TreeNode(2);
        _2.left = _4;
        TreeNode _5 = new TreeNode(7);
        _2.right = _5;
        TreeNode _6 = new TreeNode(1);
        _3.left = _6;
        TreeNode _7 = new TreeNode(3);
        _3.right = _7;
        TreeNode _8 = new TreeNode(9);
        _4.left = _8;
        TreeNode _9 = new TreeNode(1);
        _5.left = _9;
        TreeNode _10 = new TreeNode(4);
        _5.right = _10;
        TreeNode _11 = new TreeNode(5);
        _7.right = _11;
        int sum = sumEvenGrandparent(_1);
    }

    public static int sumEvenGrandparent(TreeNode root) {
        TreeNodeWithParents rootWithParents = convert(root);
        setParents(rootWithParents, null);
        setGrandParents(rootWithParents, null);
        return traverse(rootWithParents, 0);
    }

    private static TreeNodeWithParents convert(TreeNode node) {
        if (node == null)
            return null;

        TreeNodeWithParents treeNodeWithParents = TreeNodeWithParents.from(node);
        treeNodeWithParents.val = node.val;
        return treeNodeWithParents;
    }

    private static void setParents(TreeNodeWithParents node, TreeNodeWithParents parentNode) {
        if (node == null) {
            return;
        }
        node.parent = parentNode;
        setParents(node.left, node);
        setParents(node.right, node);
    }

    private static void setGrandParents(TreeNodeWithParents node, TreeNodeWithParents parentNode) {
        if (node == null) {
            return;
        }
        if (parentNode != null)
            node.grandParent = parentNode.parent;
        setGrandParents(node.left, node);
        setGrandParents(node.right, node);
    }

    private static int traverse(TreeNodeWithParents node, int sum) {
        if (node == null) {
            return sum;
        }

        if (node.grandParent != null && node.grandParent.val % 2 == 0)
            sum += node.val;

        sum = traverse(node.left, sum);
        sum = traverse(node.right, sum);
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

    static class TreeNodeWithParents {
        int val;
        TreeNodeWithParents parent;
        TreeNodeWithParents grandParent;
        TreeNodeWithParents left;
        TreeNodeWithParents right;

        TreeNodeWithParents() {
        }

        TreeNodeWithParents(int val) {
            this.val = val;
        }

        public static TreeNodeWithParents from(TreeNode treeNode) {
            if (treeNode == null)
                return null;
            TreeNodeWithParents treeNodeWithParents = new TreeNodeWithParents(treeNode.val);
            treeNodeWithParents.left = TreeNodeWithParents.from(treeNode.left);
            treeNodeWithParents.right = TreeNodeWithParents.from(treeNode.right);
            return treeNodeWithParents;
        }

        public static TreeNodeWithParents from(TreeNode treeNode, TreeNode parent) {
            if (treeNode == null) {
                return null;
            }
            TreeNodeWithParents treeNodeWithParents = new TreeNodeWithParents(treeNode.val);
            treeNodeWithParents.parent = TreeNodeWithParents.from(parent);
            treeNodeWithParents.left = TreeNodeWithParents.from(treeNode.left);
            treeNodeWithParents.right = TreeNodeWithParents.from(treeNode.right);
            return treeNodeWithParents;
        }
    }
}
