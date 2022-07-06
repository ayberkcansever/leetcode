package com.canseverayberk.leetcode.medium;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(isConnected);
    }

    public static int findCircleNum(int[][] isConnected) {

        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < isConnected.length; i++) {
            Node currentNode = nodeMap.getOrDefault(i, new Node(i));

            for (int j = 0; j < isConnected[0].length; j++) {
                if (i == j)
                    continue;

                if (isConnected[i][j] == 0)
                    continue;

                Node neighborNode = nodeMap.getOrDefault(j, new Node(j));
                nodeMap.put(j, neighborNode);
                currentNode.neighbors.add(neighborNode);
            }

            nodeMap.put(i, currentNode);
        }

        return dfs(nodeMap);
    }

    public static int dfs(Map<Integer, Node> nodeMap) {
        int count = 0;
        Node node = getFirstUnvisited(nodeMap);
        while (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);

            while (!stack.isEmpty()) {
                Node currentNode = stack.pop();
                if (!currentNode.visited) {

                    currentNode.visited = true;

                    for (Node neighbor : currentNode.neighbors) {
                        stack.push(neighbor);
                    }
                }
            }

            node = getFirstUnvisited(nodeMap);
            count++;
        }

        return count;
    }

    public static Node getFirstUnvisited(Map<Integer, Node> nodeMap) {
        for (Node node : nodeMap.values()) {
            if (!node.visited) {
                return node;
            }
        }
        return null;
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
