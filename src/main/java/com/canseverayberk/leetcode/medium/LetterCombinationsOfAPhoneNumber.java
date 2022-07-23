package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        List<String> letterCombinations = letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits))
            return List.of();

        List<List<String>> dictionary = List.of(
                List.of("a", "b", "c"),
                List.of("d", "e", "f"),
                List.of("g", "h", "i"),
                List.of("j", "k", "l"),
                List.of("m", "n", "o"),
                List.of("p", "q", "r", "s"),
                List.of("t", "u", "v"),
                List.of("w", "x", "y", "z"));

        List<String> letterCombinations = new ArrayList<>();

        for(char digitChar : digits.toCharArray()) {
            int digit = Integer.parseInt(Character.toString(digitChar));
            List<String> incomingStrings = dictionary.get(digit - 2);
            letterCombinations = letterCombinations(letterCombinations, incomingStrings);
        }

        return letterCombinations;
    }

    public static List<String> letterCombinations(List<String> currentList, List<String> incomingStrings) {
        List<String> newList = new ArrayList<>();
        if (currentList.isEmpty()) {
            for(String incoming : incomingStrings) {
                newList.add(incoming);
            }
        } else {
            for(String current : currentList) {
                for(String incoming : incomingStrings) {
                    newList.add(current + incoming);
                }
            }
        }
        return newList;
    }
}
