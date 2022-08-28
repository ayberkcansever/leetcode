package com.canseverayberk.leetcode.medium.binarysearch;

/*
https://leetcode.com/problems/find-peak-element
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 7, 9, 6, 3, 8};
        int peakElement = findPeakElement(arr);
    }

    public static int findPeakElement(int[] arr) {
        if (arr.length == 1)
            return 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (mid + 1 == arr.length)
                return mid;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;
    }
}
