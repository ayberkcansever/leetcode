package com.canseverayberk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindPathsFromSourceToTargetViaDfs {

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

        dfs(node2, node3, new ArrayList<>(), pathList);
    }

    public static void dfs(Node source, Node target, List<Node> path, List<List<Node>> result) {
        path.add(source);
        if (source.val == target.val) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        source.visited = true;

        for (Node neighbor : source.neighbors) {
            if (!neighbor.visited)
                dfs(neighbor, target, path, result);
        }

        source.visited = false;
        path.remove(path.size() - 1);
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
