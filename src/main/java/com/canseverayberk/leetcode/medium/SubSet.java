package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> subsets = subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> prevSubsets = new ArrayList<>();

        for (int num : nums) {
            List<Integer> ss = new ArrayList<>();
            ss.add(num);
            subsets.add(ss);

            for (List<Integer> prevSubset : prevSubsets) {
                List<Integer> newSs = new ArrayList<>(prevSubset);
                newSs.add(num);
                subsets.add(newSs);
            }

            prevSubsets = new ArrayList<>(subsets);
        }

        subsets.add(List.of());
        return subsets;
    }

}
