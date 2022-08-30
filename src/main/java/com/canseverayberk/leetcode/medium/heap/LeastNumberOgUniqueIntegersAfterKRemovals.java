package com.canseverayberk.leetcode.medium.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
 */
public class LeastNumberOgUniqueIntegersAfterKRemovals {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 4};
        int leastNumOfUniqueInts = findLeastNumOfUniqueInts(arr, 1);
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }

        PriorityQueue<Num> queue = new PriorityQueue<>((a, b) -> a.count - b.count > 0 ? 1 : -1);
        for (int key : map.keySet()) {
            queue.offer(new Num(key, map.get(key)));
        }

        int remaining = k;
        while (!queue.isEmpty() && remaining > 0) {
            Num num = queue.poll();
            remaining -= num.count;
            if (remaining < 0) {
                queue.offer(num);
            }
        }

        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Num num = queue.poll();
            set.add(num.val);
        }
        return set.size();
    }

    static class Num {
        int val;
        int count;

        public Num(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
