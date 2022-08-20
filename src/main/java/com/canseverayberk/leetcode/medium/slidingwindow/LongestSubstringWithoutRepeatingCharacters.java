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

        int tail = 0;
        int maxLength = 0;
        char[] chars = str.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : chars) {
            int count = countMap.getOrDefault(c, 0);
            count++;
            countMap.put(c, count);

            while (countMap.get(c) > 1) {
                char tailChar = chars[tail];
                int tailCount = countMap.get(tailChar);
                tailCount--;
                if (tailCount == 0) {
                    countMap.remove(tailChar);
                } else {
                    countMap.put(tailChar, tailCount);
                }
                tail++;
            }

            maxLength = Math.max(maxLength, countMap.keySet().size());
        }

        return maxLength;
    }
}
