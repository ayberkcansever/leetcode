package com.canseverayberk.leetcode.easy.twopointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/two-sum
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int[] indices = twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<E> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            values.add(new E(nums[i], i));
        }

        List<E> sortedValues = values.stream().sorted(Comparator.comparing(E::getVal)).collect(Collectors.toList());

        int tail = 0, head = sortedValues.size() - 1;

        int sum = sortedValues.get(head).val + sortedValues.get(tail).val;
        while (sum != target) {
            if (sum > target) {
                head--;
            } else {
                tail++;
            }
            sum = sortedValues.get(head).val + sortedValues.get(tail).val;
        }

        return new int[] {sortedValues.get(tail).index, sortedValues.get(head).index};

    }

    static class E {
        int val;
        int index;

        public E(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return val;
        }
    }
}
