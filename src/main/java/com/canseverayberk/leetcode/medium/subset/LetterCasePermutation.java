package com.canseverayberk.leetcode.medium.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/letter-case-permutation
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> letterCasePermutation = letterCasePermutation("a1b2");
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        char[] chars = s.toLowerCase().toCharArray();

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for(Character c : chars) {
            String lower = "" + c;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                try {
                    Integer.parseInt("" + c);
                    String newString = current.concat("" + c);

                    if (newString.length() == s.length()) {
                        result.add(newString);
                    }

                    queue.offer(newString);

                } catch (NumberFormatException e) {
                    String newStringWithLower = current.concat(lower); // "a"
                    String newStringWithUpper = current.concat(lower.toUpperCase()); // "A"

                    if (newStringWithLower.length() == s.length()) {
                        result.add(newStringWithLower);
                    }
                    if (newStringWithUpper.length() == s.length()) {
                        result.add(newStringWithUpper);
                    }

                    queue.offer(newStringWithLower);
                    queue.offer(newStringWithUpper);
                }
            }

        }

        return result;

    }
}
