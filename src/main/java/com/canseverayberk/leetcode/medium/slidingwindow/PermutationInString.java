package com.canseverayberk.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/permutation-in-string
 */
public class PermutationInString {

    public static void main(String[] args) {
        boolean inclusion = checkInclusion("ab", "eidbaooo");
    }

    public static boolean checkInclusion(String s1, String s2) {

        int tail = 0;
        String current = "";
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s1.toCharArray()) {
            int currentCount = map.getOrDefault(c, 0) + 1;
            map.put(c, currentCount);
        }

        Map<Character, Integer> map2 = new HashMap<>();

        for (int head = 0; head < s2.length(); head++) {
            current = current.concat(String.valueOf(s2.charAt(head)));
            int currentCount = map2.getOrDefault(s2.charAt(head), 0) + 1;
            map2.put(s2.charAt(head), currentCount);

            if (map.equals(map2)) {
                return true;
            }

            if (head - tail == s1.length() - 1) {
                tail++;
                char removed = current.toCharArray()[0];
                currentCount = map2.getOrDefault(removed, 0) - 1;
                if (currentCount == 0) {
                    map2.remove(removed);
                } else {
                    map2.put(removed, currentCount);
                }
                current = current.substring(1);
            }

        }

        return false;
    }
}
