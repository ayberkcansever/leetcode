package com.canseverayberk.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int lengthOfLongestSubstring = lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null)
            return 0;

        int maxLength = 0;
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int head = 0; head < str.length(); head++) {
            Character ch = str.charAt(head);
            Integer lastExistingIndex = indexMap.get(ch);
            if (lastExistingIndex == null) {
                indexMap.put(ch, head);
                maxLength = Math.max(maxLength, indexMap.keySet().size());
            } else {
                head = lastExistingIndex;
                indexMap.clear();
            }

        }

        return maxLength;

    }
}
