package com.canseverayberk.leetcode.easy;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int[] indices = twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int adder1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int adder2 = nums[j];
                if (adder1 + adder2 == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
