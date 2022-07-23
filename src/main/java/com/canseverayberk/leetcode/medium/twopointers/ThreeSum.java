package com.canseverayberk.leetcode.medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/3sum
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return List.of();

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (binarySearch(j + 1, nums.length - 1, nums, -(nums[i] + nums[j]))) {
                    set.add(List.of(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
        }

        return new ArrayList<>(set);
    }

    static boolean binarySearch(int l, int r, int[] nums, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == x) return true;
            else if (nums[mid] > x) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
