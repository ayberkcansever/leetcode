package com.canseverayberk.leetcode.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/concatenated-words
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(words);
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> concatenatedWords = new ArrayList<>();
        for (String word : words) {
            if (builtFrom(word, wordSet))
                concatenatedWords.add(word);
        }
        return concatenatedWords;
    }

    private static boolean builtFrom(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            String part1 = word.substring(0, i);
            String part2 = word.substring(i);
            if (wordSet.contains(part1)) {
                if (wordSet.contains(part2) || builtFrom(part2, wordSet))
                    return true;
            }
        }
        return false;
    }
}
