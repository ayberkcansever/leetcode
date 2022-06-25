package com.canseverayberk.leetcode.medium;

public class PopulatingNextRightPointers {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.left = node6;
        node3.right = node7;

        Node connected = connect(node1);
    }

    public static Node connect(Node root) {
        if(root == null || root.left == null || root.right == null)
            return root;

        root.left.next = root.right;

        if(root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
