package com.canseverayberk.leetcode.easy.heap;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream
 */
public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargestPojo = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargestPojo.add(3);
        kthLargestPojo.add(5);
        kthLargestPojo.add(10);
        kthLargestPojo.add(9);
        int kthLargest = kthLargestPojo.add(4);
    }

    static class KthLargest {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            if (nums.length == 0)
                return;

            for (int i = 0; i < Math.min(k, nums.length); i++) {
                queue.offer(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        public int add(int val) {
            if (queue.size() == 0) {
                queue.offer(val);
                return val;
            }

            if (queue.size() < k) {
                queue.offer(val);
            } else if (val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }

            return queue.peek();
        }
    }
}
