package com.canseverayberk.leetcode.medium.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        result.add(List.of());

        Queue<List<Integer>> queue = new LinkedList<>(result);

        for (int num : nums) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> currentList = queue.poll();
                List<Integer> newList = new ArrayList<>(currentList);

                newList.add(num);
                result.add(newList);

                queue.offer(currentList);
                queue.offer(newList);
            }
        }
        return result;
    }

}
