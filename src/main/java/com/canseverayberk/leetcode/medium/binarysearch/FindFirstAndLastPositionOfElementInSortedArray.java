package com.canseverayberk.leetcode.medium.binarysearch;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] searchRange = searchRange(nums, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                int startIndex = mid;
                int endIndex = mid;

                while (nums[startIndex] == target) {
                    startIndex--;
                    if (startIndex == -1)
                        break;
                }
                while (nums[endIndex] == target) {
                    endIndex++;
                    if (endIndex == nums.length)
                        break;
                }
                return new int[]{startIndex + 1, endIndex - 1};
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return new int[]{-1, -1};
    }
}
