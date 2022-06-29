package com.canseverayberk.leetcode.easy;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {
        String mostCommonWord = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        String[] words = paragraph.split("[,.\\s]");
        Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);

        Map<String, Integer> countMap = new HashMap<>();

        int max = 0;
        String maxWord = "";
        for (String s : words) {
            String word = s.toLowerCase();

            word = word.replace("\\s", "");
            word = word.replace("!", "");
            word = word.replace("?", "");
            word = word.replace("'", "");
            word = word.replace(";", "");
            word = word.replace(".", "");
            word = word.replace(",", "");

            if (bannedSet.contains(word) || "".equals(word))
                continue;
            int count = countMap.getOrDefault(word, 0) + 1;
            countMap.put(word, count);

            if (count > max) {
                max = count;
                maxWord = word;
            }
        }

        return maxWord;
    }
}
