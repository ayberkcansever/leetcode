package com.canseverayberk.leetcode.medium.twopointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/sort-colors
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, result.length);

        Arrays.fill(nums, 1);
        int head = result.length - 1, tail = 0;

        int index = 0;
        while (index < result.length) {
            int val = result[index];
            if (val == 0) {
                nums[tail] = 0;
                tail++;
            } else if (val == 2) {
                nums[head] = 2;
                head--;
            }
            index++;
        }

    }
}
