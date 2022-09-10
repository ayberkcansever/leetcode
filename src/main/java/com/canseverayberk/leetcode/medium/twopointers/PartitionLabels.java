package com.canseverayberk.leetcode.medium.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/partition-labels
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "qiejxqfnqceocmy";
        List<Integer> integers = partitionLabels(s);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> indices = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> latestIndexMap = new HashMap<>();

        for(int i = 0; i < chars.length; i++) {
            latestIndexMap.put(chars[i], i);
        }

        int index = 0;
        while(index < chars.length) {
            int pointer1 = latestIndexMap.get(chars[index]);
            int size = 0;
            while(index < pointer1) {
                pointer1 = Math.max(pointer1, latestIndexMap.get(chars[index]));
                index++;
                size++;
            }
            index++;
            indices.add(size + 1);
        }

        return indices;
    }

}
