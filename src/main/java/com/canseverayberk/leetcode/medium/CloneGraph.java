package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = cloneGraph(node1);
    }

    public static Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);

        Node cloneNode = new Node(node.val);
        Map<Integer, Node> cloneMap = new HashMap<>();
        cloneMap.put(node.val, cloneNode);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (!visited.contains(currentNode.val)) {
                visited.add(currentNode.val);

                Node currentClone = cloneMap.get(currentNode.val);
                if (currentClone == null) {
                    currentClone = new Node(currentNode.val);
                    cloneMap.put(currentNode.val, currentClone);
                }

                for(Node currentNeighbor : currentNode.neighbors) {
                    Node neighborNode = cloneMap.get(currentNeighbor.val);
                    if (neighborNode == null) {
                        neighborNode = new Node(currentNeighbor.val);
                        cloneMap.put(neighborNode.val, neighborNode);
                    }
                    currentClone.neighbors.add(neighborNode);
                    stack.push(currentNeighbor);
                }
            }
        }

        return cloneNode;

    }

    static class Node {
        public int val;
        public List<Node> neighbors;
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
