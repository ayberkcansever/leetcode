package com.canseverayberk.leetcode.medium;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minSubArrayLen = minSubArrayLen(7, nums);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target && (j - i) < minLength) {
                    minLength = j - i + 1;
                }

            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
