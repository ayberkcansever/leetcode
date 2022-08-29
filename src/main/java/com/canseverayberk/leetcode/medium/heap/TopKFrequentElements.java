package com.canseverayberk.leetcode.medium.heap;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/top-k-frequent-elements
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequent = topKFrequent(nums, k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            count++;
            map.put(n, count);
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            queue.offer(new Integer[]{key, map.get(key)});
        }

        if (queue.size() == 1)
            return new int[]{nums[0]};

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
