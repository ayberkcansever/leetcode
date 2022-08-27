package com.canseverayberk.leetcode.medium.subset;

import java.util.*;
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
        if (nums.length == 1) {
            return List.of(List.of(nums[0]));
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());

        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> l = queue.poll();
                int s = l.size();
                for (int j = 0; j <= s; j++) {
                    List<Integer> newList = new ArrayList<>(l);
                    newList.add(j, num);
                    if (newList.size() == nums.length) {
                        result.add(newList);
                    }
                    queue.offer(newList);
                }
            }
        }

        return result;
    }

}