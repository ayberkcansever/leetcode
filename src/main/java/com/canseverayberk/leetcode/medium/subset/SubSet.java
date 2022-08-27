package com.canseverayberk.leetcode.medium.subset;

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
        result.add(new ArrayList<>());

        for(int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(n);
                result.add(newList);
            }
        }
        return result;
    }

}
