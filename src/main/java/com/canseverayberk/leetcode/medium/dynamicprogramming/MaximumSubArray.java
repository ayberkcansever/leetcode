package com.canseverayberk.leetcode.medium.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-1 ,-2};
        int maxSum = maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
