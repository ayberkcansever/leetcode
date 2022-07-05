package com.canseverayberk.leetcode;

import java.util.*;

public class FindShortestPathViaBfs {

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node0.neighbors.add(node3);

        node1.neighbors.add(node3);

        node2.neighbors.add(node0);
        node2.neighbors.add(node1);

        List<List<Node>> pathList = new ArrayList<>();
        bfs(node2, node3, pathList);
    }

    public static void bfs(Node source, Node target, List<List<Node>> pathList) {
        Queue<List<Node>> queue = new LinkedList<>();

        List<Node> pathToNode = new ArrayList<>();
        pathToNode.add(source);
        queue.add(pathToNode);

        while (!queue.isEmpty()) {

            pathToNode = queue.poll();
            Node lastNode = pathToNode.get(pathToNode.size() - 1);

            if (lastNode.val == target.val) {
                pathList.add(new ArrayList<>(pathToNode));
                return;
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

}
