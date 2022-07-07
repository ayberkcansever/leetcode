package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 6}, {2, 8}, {9, 11}, {10, 17}};
        int[][] mergedIntervals = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] interval = intervals[i];
            if (i + 1 == intervals.length) {
                intervals[i] = interval;
                break;
            }
            int[] nextInterval = intervals[i + 1];

            int[] merged = new int[2];

            boolean mergedDirty = false;
            if (interval[1] < nextInterval[0]) {
                merged[0] = interval[0];
                merged[1] = interval[1];
            } else {
                merged[0] = Math.min(interval[0], nextInterval[0]);
                merged[1] = Math.max(interval[1], nextInterval[1]);
                mergedDirty = true;
            }

            if (mergedDirty) {
                intervals[i] = new int[]{-1, -1};
                intervals[i + 1] = merged;
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                result.add(interval);
            }
        }

        return result.toArray(new int[0][0]);
    }

}
