package com.canseverayberk.leetcode.hard;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String begin = "qa";
        String end = "sq";
        List<String> wordList = List.of("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        int ladderLength = ladderLength(begin, end, wordList);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, Node> nodesMap = new HashMap<>();
        Node root = new Node(beginWord);
        nodesMap.put(root.val, root);

        for(String word : wordList) {
            Node wordNode = nodesMap.getOrDefault(word, new Node(word));

            for(Node wordNode2 : nodesMap.values()) {
                if (differsOne(word, wordNode2.val)) {
                    wordNode2.neighbors.add(wordNode);
                    wordNode.neighbors.add(wordNode2);
                    nodesMap.put(wordNode2.val, wordNode2);
                }
            }

            nodesMap.put(word, wordNode);
        }

        int min = Integer.MAX_VALUE;
        List<List<Node>> result = new ArrayList<>();
        bfs(root, nodesMap.get(endWord), result);

        for(List<Node> path : result) {
            min = Math.min(min, path.size());
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static void bfs(Node source, Node target, List<List<Node>> paths) {
        Queue<List<Node>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        List<Node> path = new ArrayList<>();
        path.add(source);
        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            Node last = path.get(path.size() - 1);

            if (Objects.equals(last.val, target.val)) {
                paths.add(new ArrayList<>(path));
            }

            for (Node nextNode : last.neighbors) {
                if (!visited.contains(nextNode.val)) {
                    visited.add(nextNode.val);
                    List<Node> pathToNextNode = new ArrayList<>(path);
                    pathToNextNode.add(nextNode);
                    queue.add(pathToNextNode);
                }
            }
        }
    }

    public static boolean differsOne(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int diffCount = 0;
        for(int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                diffCount++;
                if (diffCount > 1)
                    return false;
            }
        }
        return diffCount == 1;
    }

    static class Node {

        String val;
        List<Node> neighbors;
        boolean visited;

        public Node(String val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

    }
}
