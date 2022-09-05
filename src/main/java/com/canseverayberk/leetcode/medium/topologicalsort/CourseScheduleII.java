package com.canseverayberk.leetcode.medium.topologicalsort;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(4, prerequisites);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodesMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node(i);
            nodesMap.put(node.val, node);
        }

        Set<Integer> neighbourSet = new HashSet<>();

        for (int[] prerequisite : prerequisites) {
            Node node = nodesMap.getOrDefault(prerequisite[0], new Node(prerequisite[0]));
            Node neighbour = nodesMap.getOrDefault(prerequisite[1], new Node(prerequisite[1]));
            if (node.val == neighbour.val)
                return new int[]{};

            node.neighbors.add(neighbour);
            neighbourSet.add(neighbour.val);

            nodesMap.put(node.val, node);
            nodesMap.put(neighbour.val, neighbour);
        }

        int index = numCourses - 1;
        int[] order = new int[numCourses];

        boolean circular = false;
        while (nodesMap.size() > 0) {
            neighbourSet = new HashSet<>();
            for (Node node : nodesMap.values()) {
                for (Node neighbor : node.neighbors) {
                    neighbourSet.add(neighbor.val);
                }
            }

            Set<Node> sourceNodes = new HashSet<>();
            for (Node node : nodesMap.values()) {
                if (!neighbourSet.contains(node.val)) {
                    sourceNodes.add(node);
                }
            }

            if (sourceNodes.size() == 0) {
                circular = true;
                break;
            }

            for (Node sourceNode : sourceNodes) {
                nodesMap.remove(sourceNode.val);
                order[index--] = sourceNode.val;
            }

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

        return circular ? new int[]{} : order;
    }

    static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

    }
}
