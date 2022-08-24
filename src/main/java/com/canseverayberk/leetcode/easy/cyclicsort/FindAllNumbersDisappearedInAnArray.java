package com.canseverayberk.leetcode.easy.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            while (nums[index] != nums[nums[index] - 1]) {
                int temp = nums[nums[index] - 1];
                nums[nums[index] - 1] = nums[index];
                nums[index] = temp;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] - 1 != index) {
                result.add(index + 1);
            }
        }
        return result;

    }
}
