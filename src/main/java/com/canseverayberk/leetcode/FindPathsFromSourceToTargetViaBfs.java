package com.canseverayberk.leetcode;

import com.canseverayberk.leetcode.hard.WordLadder;

import java.util.*;

public class FindPathsFromSourceToTargetViaBfs {

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

    private static void bfs(Node source, Node target, List<List<Node>> paths) {
        Queue<List<Node>> queue = new LinkedList<>();

        List<Node> path = new ArrayList<>();
        path.add(source);
        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            Node last = path.get(path.size() - 1);

            if (last.val == target.val) {
                paths.add(new ArrayList<>(path));
            }

            for (Node neighbor : last.neighbors) {
                if (isNotVisited(neighbor, path)) {
                    List<Node> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }
    }

    private static boolean isNotVisited(Node node, List<Node> path) {
        for (Node value : path)
            if (value.val == node.val)
                return false;
        return true;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

}
