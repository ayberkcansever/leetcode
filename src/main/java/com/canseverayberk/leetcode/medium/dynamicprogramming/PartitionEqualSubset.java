package com.canseverayberk.leetcode.medium.dynamicprogramming;

/*
https://leetcode.com/problems/partition-equal-subset-sum
 */
public class PartitionEqualSubset {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean canPartition = canPartition(nums);
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        if (totalSum % 2 == 1)
            return false;

        int sum = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length + 1][sum + 1];
        return search(nums, 0, sum, dp);
    }

    public static boolean search(int[] nums, int i, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (sum < 0)
            return false;
        if (i >= nums.length)
            return false;

        Boolean result = dp[i][sum];
        if (result == null) {
            result = search(nums, i + 1, sum - nums[i], dp) || search(nums, i + 1, sum, dp);
            dp[i][sum] = result;
        }
        return result;
    }
}
