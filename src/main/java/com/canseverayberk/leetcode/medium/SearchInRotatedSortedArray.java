package com.canseverayberk.leetcode.medium;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result = search(nums, 3);
    }

    public static int search(int[] nums, int target) {
        int pivotIndex = -1;
        int pivotFirst = nums[0];
        int pivotLargest = -1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                pivotIndex = i;
                pivotLargest = prev;
                break;
            }
            prev = nums[i];
        }

        if (pivotIndex == -1) {
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            } else {
                pivotIndex = 0;
                pivotLargest = nums[nums.length - 1];
            }
        }

        if (target >= pivotFirst && target <= pivotLargest) {
            return binarySearch(Arrays.copyOfRange(nums, 0, pivotIndex == 0 ? nums.length : pivotIndex), target, 0);
        } else {
            int index = binarySearch(Arrays.copyOfRange(nums, pivotIndex, nums.length), target, 0);
            if (index != -1)
                return pivotIndex + index;
            return -1;
        }
    }

    private static int binarySearch(int[] array, int target, int prevIndex) {
        if (array.length == 0)
            return -1;
        if (array.length == 1) {
            return array[0] == target ? 0 : -1;
        }

        int middleIndex = array.length / 2;
        if (array[middleIndex] < target) {
            int index = binarySearch(Arrays.copyOfRange(array, middleIndex, array.length), target, prevIndex);
            if (index == -1) {
                return -1;
            } else {
                return middleIndex + index;
            }
        } else if (array[middleIndex] > target) {
            return binarySearch(Arrays.copyOfRange(array, 0, middleIndex), target, 0);
        } else {
            return middleIndex;
        }
    }
}
