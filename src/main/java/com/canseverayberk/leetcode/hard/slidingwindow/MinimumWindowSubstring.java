package com.canseverayberk.leetcode.hard.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
    }

    private static Set<Character> validCharSet;
    private static Map<Character, Long> characterCountMapT;

    public static String minWindow(String s, String t) {
        validCharSet = getCharSet(t);
        characterCountMapT = getCharList(t).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return minWindow(s, t, "", 0, 0, new HashMap<>());
    }

    public static String minWindow(String s, String t, String prevMinWindow, int tail, int head, HashMap<Character, Long> characterCountMapWindow) {
        if (s.length() < t.length())
            return "";
        if (s.equals(t))
            return s;
        if (prevMinWindow.equals(t))
            return prevMinWindow;

        String window = s.substring(tail, head);

        while (!containsAll(window, t, characterCountMapWindow)) {
            head++;
            if (head > s.length()) {
                if (containsAll(window, t, characterCountMapWindow)) {
                    prevMinWindow = window;
                }
                return prevMinWindow;
            }

            window = s.substring(tail, head);
            Character newChar = window.substring(window.length() - 1).charAt(0);
            Long count = characterCountMapWindow.get(newChar);
            if (count == null)
                count = 1L;
            else
                count++;
            characterCountMapWindow.put(newChar, count);
        }

        if (prevMinWindow.isEmpty() || prevMinWindow.length() > window.length()) {
            prevMinWindow = window;
        }

        if (prevMinWindow.length() == t.length())
            return prevMinWindow;

        while (containsAll(window, t, characterCountMapWindow) && window.length() > t.length()) {
            tail++;
            window = s.substring(tail, head);

            Character deletedChar = s.substring(tail - 1, tail).charAt(0);
            Long count = characterCountMapWindow.get(deletedChar);
            if (count == null)
                count = 0L;
            else
                count--;
            characterCountMapWindow.put(deletedChar, count);

            if (window.isEmpty())
                return prevMinWindow;
            if (prevMinWindow.length() > window.length() && containsAll(window, t, characterCountMapWindow)) {
                prevMinWindow = window;
            }
        }
        while (!validCharSet.contains(window.charAt(0))) {
            tail++;
            window = s.substring(tail, head);
        }
        window = minWindow(s, t, prevMinWindow, tail, head, characterCountMapWindow);
        return window;
    }

    private static Set<Character> getCharSet(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    private static List<Character> getCharList(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    private static boolean containsAll(String window, String t, Map<Character, Long> characterCountMapWindow) {
        if (t.isEmpty())
            return false;

        int equalCount = 0;
        for (Character charT : validCharSet) {
            Long countWindow = characterCountMapWindow.get(charT);
            if (countWindow == null)
                return false;
            Long countT = characterCountMapT.get(charT);
            if (countWindow >= countT)
                equalCount++;
        }
        return window.length() > 0 && equalCount == validCharSet.size();
    }

}
