package com.canseverayberk.leetcode.easy.binarysearch;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = new char[] {'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n'};
        char nextGreatestLetter = nextGreatestLetter(letters, 'e');
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        List<Character> set = new LinkedList<>();
        for(char c : letters) {
            if (!set.contains(c))
                set.add(c);
        }

        int left = 0;
        int right = set.size() - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);
            if (set.get(mid) == target) {
                return set.get((mid + 1) % set.size());
            }

            if (set.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return set.get(left % set.size());
    }
}
