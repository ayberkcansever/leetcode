package com.canseverayberk.leetcode.easy.binarysearch;

/*
https://leetcode.com/problems/search-insert-position
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int insertedIndex = searchInsert(nums, 2);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = left + ((right - left) / 2);
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;
    }
}
