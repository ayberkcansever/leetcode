package com.canseverayberk.leetcode.medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 6}, {2, 8}, {9, 11}, {10, 17}};
        int[][] mergedIntervals = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        int[] merged = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (merged[1] < interval[0]) {
                result.add(merged);
                merged = interval;
            } else {
                merged[0] = Math.min(merged[0], interval[0]);
                merged[1] = Math.max(merged[1], interval[1]);
            }

        }

        result.add(merged);
        return result.toArray(new int[0][0]);
    }

}
