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
        for(int i : nums) {
            totalSum += i;
        }
        if (totalSum % 2 == 1)
            return false;

        int searched = totalSum / 2;

        boolean[][] dp = new boolean[nums.length][searched + 1];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j < searched + 1; j++) {
                boolean prev = false;
                if(i >= 1) {
                    prev = dp[i - 1][j];
                }

                boolean diff = false;
                int difference = j - nums[i];
                if (i >= 1 && difference >= 0) {
                    diff = dp[i-1][difference];
                }

                boolean me = (j - nums[i]) == 0;
                dp[i][j] = prev || diff || me;
            }
        }

        return dp[nums.length - 1][searched];
    }

/*

        [9,1,2,4,10]  -> 13

        i/j     1   2   3   4   5   6   7   8   9   10  11  12  13
        9       F   F   F   F   F   F   F   F   T   F   F   F   F
        1       T   F   F   F   F   F   F   F   T   T   F   F   F
        2       T   T   T   F   F   F   F   F   T   T   T   T   F
        4       T   T   T   T   T   T   T   F   T   T   T   T   F
        10      T   T   T   T   T   T   T   T   T   T   T   T   T

 */
}
