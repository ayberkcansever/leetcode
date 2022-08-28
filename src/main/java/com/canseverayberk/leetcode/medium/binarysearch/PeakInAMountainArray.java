package com.canseverayberk.leetcode.medium.binarysearch;

/*
https://leetcode.com/problems/peak-index-in-a-mountain-array
 */
public class PeakInAMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 10, 5, 2};
        int peakIndexInMountainArray = peakIndexInMountainArray(arr);
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;
    }
}
