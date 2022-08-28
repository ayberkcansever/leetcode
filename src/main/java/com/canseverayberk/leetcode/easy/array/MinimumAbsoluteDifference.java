package com.canseverayberk.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/minimum-absolute-difference
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 1, 3};
        List<List<Integer>> minimumAbsDifferenceElements = minimumAbsDifference(nums);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int n = arr[i];
            int diff = n - prev;
            List<Integer> list = new ArrayList<>();

            if (diff < minDiff) {
                result = new ArrayList<>();
                list.add(prev);
                list.add(n);
                result.add(list);
                minDiff = diff;
            } else if (diff == minDiff) {
                list.add(prev);
                list.add(n);
                result.add(list);
            }

            prev = n;
        }

        return result;

    }
}
