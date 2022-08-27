package com.canseverayberk.leetcode.medium.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets-ii
 */
public class SubSetII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int n : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(n);
                if (!result.contains(newList)) {
                    result.add(newList);
                }
            }

        }

        return result;
    }

}
