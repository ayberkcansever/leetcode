package com.canseverayberk.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        List<Node> pathList = bfs(node2, node3);
    }

    public static List<Node> bfs(Node source, Node target) {
        Queue<List<Node>> queue = new LinkedList<>();

        List<Node> pathToNode = new ArrayList<>();
        pathToNode.add(source);
        queue.add(pathToNode);

        while (!queue.isEmpty()) {

            pathToNode = queue.poll();
            Node lastNode = pathToNode.get(pathToNode.size() - 1);

            if (lastNode.val == target.val) {
                return pathToNode;
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

        return List.of();
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
