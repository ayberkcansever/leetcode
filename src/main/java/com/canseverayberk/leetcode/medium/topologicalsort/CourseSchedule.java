package com.canseverayberk.leetcode.medium.topologicalsort;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0, 10}, {3, 18}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        boolean canFinish = canFinish(20, prerequisites);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Node> nodesMap = new HashMap<>();
        Set<Integer> neighbourSet = new HashSet<>();

        for (int[] prerequisite : prerequisites) {
            Node node = nodesMap.getOrDefault(prerequisite[0], new Node(prerequisite[0]));
            Node neighbour = nodesMap.getOrDefault(prerequisite[1], new Node(prerequisite[1]));
            if (node.val == neighbour.val)
                return false;

            node.neighbors.add(neighbour);
            neighbourSet.add(neighbour.val);

            nodesMap.put(node.val, node);
            nodesMap.put(neighbour.val, neighbour);
        }

        while (nodesMap.size() > 0) {
            neighbourSet = new HashSet<>();
            // determine all neighbors
            for (Node node : nodesMap.values()) {
                for (Node neighbor : node.neighbors) {
                    neighbourSet.add(neighbor.val);
                }
            }

            // determine source nodes
            Set<Node> sourceNodes = new HashSet<>();
            for (Node node : nodesMap.values()) {
                if (!neighbourSet.contains(node.val)) {
                    sourceNodes.add(node);
                }
            }

            // if no source node break, means cycle
            if (sourceNodes.size() == 0)
                break;

            // remove source nodes from the map
            for (Node sourceNode : sourceNodes) {
                nodesMap.remove(sourceNode.val);
            }

            // remove source nodes from neighbors
            for (Node node : nodesMap.values()) {
                Iterator<Node> iter = node.neighbors.iterator();
                while (iter.hasNext()) {
                    Node neighbor = iter.next();
                    if (sourceNodes.contains(neighbor)) {
                        iter.remove();
                    }
                }
            }
        }

        return nodesMap.size() == 0;
    }


    static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

    }
}
