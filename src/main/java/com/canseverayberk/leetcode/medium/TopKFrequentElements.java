package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequent = topKFrequent(nums, k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            Integer count = countMap.get(num);
            if (Objects.isNull(count)) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
            }
        }
        List<Integer> sorted = countMap.values().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        Collections.reverse(sorted);
        Set<Integer> topTwoValues = new HashSet<>(sorted.subList(0, k));

        List<Integer> resultList = new ArrayList<>();

        countMap.keySet().forEach(num -> {
            if (topTwoValues.contains(countMap.get(num))) {
                resultList.add(num);
            }
        });

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
