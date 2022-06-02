package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {


    public static void main(String[] args) {
        String s = "qiejxqfnqceocmy";
        List<Integer> integers = partitionLabels(s);
    }

    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0)
            return List.of();
        List<Integer> result = new ArrayList<>();
        s = giveRemainingString(s, result);
        while(s.length() > 0) {
            s = giveRemainingString(s, result);
        }
        return result;
    }

    private static String giveRemainingString(String s, List<Integer> list) {
        String firstLetter = String.valueOf(s.charAt(0));
        int lastIndexOfFirstLetter = s.lastIndexOf(firstLetter);
        String splittedString = s.substring(0, lastIndexOfFirstLetter);
        int newLastIndex = 0;

        while (newLastIndex < lastIndexOfFirstLetter) {
            for(int i = 0; i < splittedString.length(); i++) {
                char charAt = splittedString.charAt(i);
                int lastIndex = s.lastIndexOf(charAt);
                newLastIndex = Math.max(lastIndex, newLastIndex);
                splittedString = s.substring(0, newLastIndex);
            }
        }

        newLastIndex += 1;
        list.add(newLastIndex);
        return s.substring(newLastIndex);
    }

}
