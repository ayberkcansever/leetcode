package com.canseverayberk.leetcode.easy.binarysearch;

/*
https://leetcode.com/problems/binary-search
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,3,5,9,12};
        int foundAt = search(nums, 9);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midIndex = left + ((right - left) / 2);

            if (target == nums[midIndex])
                return midIndex;

            if (nums[midIndex] > target) {
                right = midIndex - 1;
            } else if (nums[midIndex] < target) {
                left = midIndex + 1;
            }
        }

        return -1;
    }
}
