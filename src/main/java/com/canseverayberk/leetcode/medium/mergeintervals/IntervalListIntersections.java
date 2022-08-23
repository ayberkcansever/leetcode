package com.canseverayberk.leetcode.medium.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/interval-list-intersections
 */
public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstList = new int[][] {new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}};
        int[][] secondList = new int[][] {new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}};
        int[][] intervalIntersection = intervalIntersection(firstList, secondList);
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        for(int[] interval1 : firstList) {

            for(int[] interval2 : secondList) {

                int lo = Math.max(interval1[0], interval2[0]);
                int hi = Math.min(interval1[1], interval2[1]);
                if (lo <= hi) {
                    result.add(new int[]{lo, hi});
                }

                if (interval1[1] < interval2[1]) {
                    break;
                }
            }
        }

        return result.toArray(new int[0][0]);
    }
}


