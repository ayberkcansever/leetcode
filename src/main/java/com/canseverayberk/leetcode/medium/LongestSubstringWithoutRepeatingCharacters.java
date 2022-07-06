package com.canseverayberk.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int lengthOfLongestSubstring = lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s ==null)
            return 0;

        int maxLength = 0;

        for (int i = 0; i < s.length() - maxLength; i++) {
            int count = 0;
            Set<Character> existingCharSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (existingCharSet.contains(currentChar)) {
                    break;
                }
                existingCharSet.add(currentChar);
                count++;
            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;

    }
}
