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

        int searched = totalSum / 2;

        Boolean[][] cache = new Boolean[nums.length + 1][searched + 1];
        return recursive(cache, nums, 0, searched, searched);
    }

    public static boolean recursive(Boolean[][] cache, int[] nums, int index, int remaining, int target) {

        if (remaining == 0) {
            cache[index][remaining] = true;
            return cache[index][remaining];
        }

        if (index == nums.length || remaining < 0) {
            return false;
        }

        if (nums[index] > target) {
            cache[index][remaining] = false;
            return cache[index][remaining];
        } else {
            Boolean cached = cache[index][remaining];
            if (cached != null)
                return cached;

            Boolean result = recursive(cache, nums, index + 1, remaining, target) ||
                    recursive(cache, nums, index + 1, remaining - nums[index], target);
            cache[index][remaining] = result;
            return result;
        }

    }

}
