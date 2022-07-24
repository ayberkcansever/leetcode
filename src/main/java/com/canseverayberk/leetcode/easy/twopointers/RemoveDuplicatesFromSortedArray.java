package com.canseverayberk.leetcode.easy.twopointers;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int duplicatesRemoved = removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int resultPointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[resultPointer] = nums[i];
                resultPointer++;
            }
        }

        return resultPointer;
    }
}
