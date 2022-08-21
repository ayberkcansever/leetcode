package com.canseverayberk.leetcode.easy.twopointers;

import java.util.*;

/*
https://leetcode.com/problems/two-sum
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int[] indices = twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            List<Integer> indexes = indexMap.getOrDefault(nums[index], new ArrayList<>());
            indexes.add(index);
            indexMap.put(nums[index], indexes);
        }

        Arrays.sort(nums);

        int pointer1 = 0;
        int pointer2 = nums.length - 1;

        int sum = nums[pointer1] + nums[pointer2];

        while (sum != target) {
            if (sum > target) {
                pointer2--;
            } else {
                pointer1++;
            }
            sum = nums[pointer1] + nums[pointer2];
        }

        int firstIndex = indexMap.get(nums[pointer1]).get(0);
        indexMap.get(nums[pointer1]).remove(0);
        int secondIndex = indexMap.get(nums[pointer2]).get(0);

        return new int[] {firstIndex, secondIndex};
    }

}
