package com.canseverayberk.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class TopologicalSort {

    public static void main(String[] args) {
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node40 = new Node(40);
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        Node node70 = new Node(70);

        node10.neighbors.add(node30);

        node20.neighbors.add(node10);
        node20.neighbors.add(node30);
        node20.neighbors.add(node50);
        node20.neighbors.add(node60);

        node30.neighbors.add(node60);

        node40.neighbors.add(node10);
        node40.neighbors.add(node20);

        node50.neighbors.add(node70);

        node60.neighbors.add(node70);

        List<Node> topologicalSort = new ArrayList<>();
        topologicalSort(node40, topologicalSort);
    }

    public static void topologicalSort(Node node, List<Node> topologicalSort) {
        for (Node neighbor : node.neighbors) {
            if (!neighbor.visited) {
                topologicalSort(neighbor, topologicalSort);
                neighbor.visited = true;
            }
        }
        topologicalSort.add(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public boolean visited;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
