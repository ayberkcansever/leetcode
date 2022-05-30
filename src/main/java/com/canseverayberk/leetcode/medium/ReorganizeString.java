package com.canseverayberk.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReorganizeString {

    public static void main(String[] args) {
        String s = "aab";
        String reorganizedString = reorganizeString(s);
    }

    public static String reorganizeString(String s) {
        String reorganizedString = buildString(s.length(), s, "", ' ');
        return reorganizedString.length() < s.length() ? "" : reorganizedString;
    }

    private static String buildString(int resultLength, String s, String current, Character exceptionalChar) {
        if (current.length() == resultLength) {
            return "";
        }
        LinkedHashMap<Character, Integer> frequencyMap = buildFrequencyMap(s, exceptionalChar);
        if (frequencyMap.entrySet().size() == 0) {
            return "";
        }
        Character newChar = frequencyMap.entrySet().iterator().next().getKey();
        current = current.concat(newChar.toString());
        return newChar.toString().concat(buildString(resultLength, s.replaceFirst(newChar.toString(), ""), current, newChar));
    }

    private static LinkedHashMap<Character, Integer>  buildFrequencyMap(String s, Character exceptionalChar) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = frequencyMap.get(c);
            if (count == null) {
                count = 1;
            } else {
                count += 1;
            }
            if (c != exceptionalChar)
                frequencyMap.put(c, count);
        }

        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortedMap;
    }

}
