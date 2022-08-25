package com.canseverayberk.leetcode.medium.bfstree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 */
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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Node> levelNodes = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelNodes.add(node);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            Node prevNode = null;
            for(Node node : levelNodes) {
                if (prevNode != null) {
                    prevNode.next = node;
                }
                prevNode = node;
            }
        }
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
