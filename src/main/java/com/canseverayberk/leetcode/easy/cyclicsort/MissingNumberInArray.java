package com.canseverayberk.leetcode.easy.cyclicsort;

/*
https://leetcode.com/problems/missing-number
 */
public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 0 ,1};
        int missingNumber = missingNumber(nums);
    }

    public static int missingNumber(int[] nums) {
        for(int index = 0; index < nums.length; index++) {
            while(index != nums[index] && nums[index] < nums.length) {
                int temp = nums[nums[index]];
                nums[nums[index]] = nums[index];
                nums[index] = temp;
            }
        }

        for(int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }
        return nums.length;
    }
}
