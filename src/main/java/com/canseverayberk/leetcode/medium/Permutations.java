package com.canseverayberk.leetcode.medium;

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
        List<List<Integer>> result = new ArrayList<>();
        heapPermutation(result, nums, nums.length);
        return result;
    }

    private static void heapPermutation(List<List<Integer>> result, int[] nums, int size) {
        if (size == 1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(result, nums, size - 1);
            int temp;
            if (size % 2 == 1) {
                temp = nums[0];
                nums[0] = nums[size - 1];
            } else {
                temp = nums[i];
                nums[i] = nums[size - 1];
            }
            nums[size - 1] = temp;
        }
    }

}