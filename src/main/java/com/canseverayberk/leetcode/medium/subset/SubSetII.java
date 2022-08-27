package com.canseverayberk.leetcode.medium.subset;

import java.util.*;

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
        result.add(List.of());

        Queue<List<Integer>> queue = new LinkedList<>(result);

        for (int num : nums) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> currentList = queue.poll();
                List<Integer> newList = new ArrayList<>(currentList);

                newList.add(num);
                if (!result.contains(newList))
                    result.add(newList);

                queue.offer(currentList);
                queue.offer(newList);
            }
        }
        return result;
    }

}
