package com.canseverayberk.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        int[] nums = new int[] {30, 20, 150, 100, 40};
        int count = numPairsDivisibleBy60(nums);
    }

    public static int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int j : time) {

            int needsMe = j % 60;
            int iNeed = (60 - (j % 60)) % 60;

            Integer needsCount = map.get(needsMe);
            count += (needsCount == null ? 0 : needsCount);

            Integer iNeedCount = map.get(iNeed);
            if (iNeedCount == null) {
                iNeedCount = 1;
            } else {
                iNeedCount = iNeedCount + 1;
            }
            map.put(iNeed, iNeedCount);
        }
        return count;
    }
}
