package com.canseverayberk.leetcode.medium.heap;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> topKFrequentWords = topKFrequent(words, 2);
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> countMap = new HashMap<>();

        for (String s : words) {
            int count = countMap.getOrDefault(s, 0);
            countMap.put(s, count + 1);
        }

        PriorityQueue<WordCount> queue = new PriorityQueue<>((a, b) -> {
            if (a.count > b.count)
                return 1;
            else if (a.count < b.count)
                return -1;
            else {
                return b.word.compareTo(a.word);
            }
        }); // minHeap

        List<String> keys = new ArrayList<>(countMap.keySet());

        for (int i = 0; i < k; i++) {
            String key = keys.get(i);
            queue.offer(new WordCount(key, countMap.get(key)));
        }

        for (int i = k; i < keys.size(); i++) {
            String key = keys.get(i);
            WordCount word = new WordCount(key, countMap.get(key));
            if (word.count > queue.peek().count || (word.count == queue.peek().count && word.word.compareTo(queue.peek().word) < 0)) {
                queue.poll();
                queue.offer(word);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().word);
        }
        Collections.reverse(result);
        return result;
    }

    static class WordCount {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
