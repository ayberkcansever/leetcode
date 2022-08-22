package com.canseverayberk.leetcode.medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {new int[]{1, 3}, new int[]{6, 9}};
        int[][] inserted = insert(intervals, new int[]{2, 5});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        List<int[]> result = new ArrayList<>();

        List<int[]> intersectedIntervals = new ArrayList<>();

        List<int[]> nonIntersectedIntervals = new ArrayList<>();
        for(int[] interval : intervals) {
            if (
                    (newInterval[0] <= interval[1] && newInterval[0] >= interval[0]) ||
                            (newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) ||
                            (newInterval[0] <= interval[0] && newInterval[1] >= interval[1]) ||
                            (newInterval[1] >= interval[0] && newInterval[1] <= interval[1])
            ) {
                intersectedIntervals.add(interval);
            } else {
                nonIntersectedIntervals.add(interval);
            }
        }

        if (intersectedIntervals.size() > 0) {
            intersectedIntervals.add(newInterval);
        } else {
            nonIntersectedIntervals.add(newInterval);
        }

        int[] merged = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int[] interval : intersectedIntervals) {
            merged[0] = Math.min(merged[0], interval[0]);
            merged[1] = Math.max(merged[1], interval[1]);
        }

        if (nonIntersectedIntervals.size() == 0) {
            return new int[][] {merged};
        }

        boolean mergeAdded = false;
        for(int[] interval : nonIntersectedIntervals) {
            if (!mergeAdded && interval[0] > merged[1] && merged[1] > Integer.MIN_VALUE) {
                result.add(merged);
                mergeAdded = true;
            }
            result.add(interval);
        }

        if (!mergeAdded && merged[1] > Integer.MIN_VALUE) {
            result.add(merged);
        }

        int[][] res = result.toArray(new int[0][0]);
        Arrays.sort(res, Comparator.comparing(interval -> interval[0]));
        return res;
    }
}
