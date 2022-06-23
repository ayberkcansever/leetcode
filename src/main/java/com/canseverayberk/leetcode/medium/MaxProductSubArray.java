package com.canseverayberk.leetcode.medium;

/*
https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, -2, -9, -6};
        int maxProduct = maxProduct(nums);
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(Math.max(nums[0], nums[0] * nums[1]), nums[1]);

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0]; // -1
        int result = nums[0]; // -1

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;

    }
}
