package com.canseverayberk.leetcode.medium;

import java.util.*;

public class AllNodesDistanceKInBinary {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        node.left = new TreeNode(5);
        node.right = new TreeNode(1);

        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);

        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        List<Integer> nodes = distanceK(node, new TreeNode(5), 2);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        traverse(root, nodeMap);

        Node graph = nodeMap.get(target.val);
        return bfs(graph, k);
    }

    public static List<Integer> bfs(Node node, int k) {
        Queue<List<Node>> queue = new LinkedList<>();

        List<Node> pathToNode = new ArrayList<>();
        pathToNode.add(node);
        queue.add(pathToNode);

        List<Integer> nodeList = new ArrayList<>();

        while (!queue.isEmpty()) {
            pathToNode = queue.poll();
            Node lastNode = pathToNode.get(pathToNode.size() - 1);
            lastNode.visited = true;

            if (pathToNode.size() == k + 1) {
                nodeList.add(pathToNode.get(k).val);
            }

            for (Node nextNode : lastNode.neighbors) {
                if (!nextNode.visited) {
                    nextNode.visited = true;
                    List<Node> pathToNextNode = new ArrayList<>(pathToNode);
                    pathToNextNode.add(nextNode);
                    queue.add(pathToNextNode);
                }
            }
        }
        return nodeList;
    }

    public static void traverse(TreeNode root, Map<Integer, Node> nodeMap) {
        if (root == null)
            return;

        Node rootNode = nodeMap.getOrDefault(root.val, new Node(root.val));

        if (root.left != null) {
            Node leftRootNode = nodeMap.getOrDefault(root.left.val, new Node(root.left.val));
            rootNode.neighbors.add(leftRootNode);
            leftRootNode.neighbors.add(rootNode);
            nodeMap.put(leftRootNode.val, leftRootNode);
        }

        if (root.right != null) {
            Node rightRootNode = nodeMap.getOrDefault(root.right.val, new Node(root.right.val));
            rootNode.neighbors.add(rightRootNode);
            rightRootNode.neighbors.add(rootNode);
            nodeMap.put(rightRootNode.val, rightRootNode);
        }

        nodeMap.put(rootNode.val, rootNode);

        traverse(root.left, nodeMap);
        traverse(root.right, nodeMap);
    }


    static class Node {
        int val;
        List<Node> neighbors;
        boolean visited;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
