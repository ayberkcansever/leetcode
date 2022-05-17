package com.canseverayberk.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-1 ,-2};
        int maxSum = maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        int max = sumArray[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = Math.max(nums[i] + sumArray[i - 1], nums[i]);
            if (max < sumArray[i])
                max = sumArray[i];
        }

        return max;
    }

}
