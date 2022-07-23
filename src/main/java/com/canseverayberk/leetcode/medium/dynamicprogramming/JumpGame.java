package com.canseverayberk.leetcode.medium.dynamicprogramming;

/*
https://leetcode.com/problems/jump-game
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        boolean canJump = canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int maxIndex = nums[0];
        if (maxIndex == 0)
            return false;
        for(int i = 1; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex <= i)
                return false;
        }
        return (maxIndex >= nums.length - 1);
    }
}
