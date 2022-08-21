package com.canseverayberk.leetcode.medium.twopointers;

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubArray {

    public static void main(String[] args) {
        int[] nums = new int[] {2,6,4,8,10,9,15};
        int unsortedSubarrayLength = findUnsortedSubarray(nums);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
