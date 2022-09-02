package com.canseverayberk.leetcode.medium.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 7, 11};
        int[] nums2 = new int[] {2, 4, 6};
        List<List<Integer>> kSmallestPairs = kSmallestPairs(nums1, nums2, 3);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int min1 = nums1[0];
        int min2 = nums2[0];

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> a.sum() > b.sum() ? -1 : 1);

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                Pair pair = new Pair(nums1[i], nums2[j]);
                maxHeap.offer(pair);
                if (maxHeap.size() == k)
                    break;
            }
            if (maxHeap.size() == k)
                break;
        }

        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] + min2 > maxHeap.peek().sum())
                break;
            for(int j = 0; j < nums2.length; j++) {
                if ( (i * nums2.length + j) < k)
                    continue;
                if (nums2[j] + min1 > maxHeap.peek().sum())
                    break;

                Pair pair = new Pair(nums1[i], nums2[j]);
                if (pair.sum() < maxHeap.peek().sum()) {
                    maxHeap.poll();
                    maxHeap.offer(pair);
                }
            }

        }

        List<List<Integer>> result = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            result.add(List.of(pair.n1, pair.n2));
        }

        return result;
    }

    static class Pair {
        int n1;
        int n2;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public int sum() {
            return n1 + n2;
        }
    }
}
