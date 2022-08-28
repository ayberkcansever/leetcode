package com.canseverayberk.leetcode.medium.binarysearch;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int min = findMin(nums);
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0])
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return 0;
    }
}
