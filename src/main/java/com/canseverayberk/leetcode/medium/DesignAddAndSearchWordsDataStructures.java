package com.canseverayberk.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class DesignAddAndSearchWordsDataStructures {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }

    static class WordDictionary {

        private Map<Integer, Set<String>> wordsMap;
        private Map<String, Pattern> patternMap;
        private Set<String> existingSet;
        private Set<String> nonExistingSet;

        public WordDictionary() {
            wordsMap = new HashMap<>();
            patternMap = new HashMap<>();
            existingSet = new HashSet<>();
            nonExistingSet = new HashSet<>();
            for (int i = 1; i <= 25; i++) {
                wordsMap.put(i, new HashSet<>());
            }
        }

        public void addWord(String word) {
            wordsMap.get(word.length()).add(word);
            nonExistingSet.clear();
        }

        public boolean search(String word) {
            if (existingSet.contains(word)) {
                return true;
            } else if (nonExistingSet.contains(word)){
                return false;
            } else {
                Pattern pattern = patternMap.get(word);
                if (pattern == null) {
                    pattern = Pattern.compile(word);
                    patternMap.put(word, pattern);
                }
                for(String existingWord : wordsMap.get(word.length())) {
                    if (pattern.matcher(existingWord).matches()) {
                        existingSet.add(word);
                        return true;
                    }
                }
                nonExistingSet.add(word);
                return false;
            }
        }
    }
}
