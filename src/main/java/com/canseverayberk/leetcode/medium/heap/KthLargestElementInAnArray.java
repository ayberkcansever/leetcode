package com.canseverayberk.leetcode.medium.heap;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest(nums, 4);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (a - b));

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }

}
