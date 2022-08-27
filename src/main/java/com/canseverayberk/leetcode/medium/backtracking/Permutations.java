package com.canseverayberk.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 1) {
            return List.of(List.of(nums[0]));
        }
        List<List<Integer>> finalResult = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                if (result.get(i).size() == 0) {
                    result.get(i).add(num);
                    break;
                }
                int s = result.get(i).size();
                for(int j = 0; j <= s; j++) {
                    List<Integer> newList = new ArrayList<>(result.get(i));
                    newList.add(j, num);
                    result.add(newList);

                    if(newList.size() == nums.length) {
                        finalResult.add(new ArrayList<>(newList));
                    }
                }
            }
        }

        return finalResult;
    }

}