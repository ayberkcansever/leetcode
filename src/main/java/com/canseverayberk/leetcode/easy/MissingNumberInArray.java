package com.canseverayberk.leetcode.easy;

import java.util.Arrays;

public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 0 ,1};
        int missingNumber = missingNumber(nums);
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums[nums.length - 1] + 1;
    }
}
