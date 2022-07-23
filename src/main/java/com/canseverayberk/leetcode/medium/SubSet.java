package com.canseverayberk.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets
 */
public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> subsets = subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i + 1, subset, result);

        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, result);
    }
}
