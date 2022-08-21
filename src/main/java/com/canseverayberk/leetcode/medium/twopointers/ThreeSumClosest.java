package com.canseverayberk.leetcode.medium.twopointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-closest
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[] {4,0,5,-5,3,3,0,-4,-5};
        int sumClosest = threeSumClosest(nums, -2);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int smallestDiff = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int pointer1 = i + 1, pointer2 = nums.length - 1;
            while (pointer1 < pointer2) {
                int diff = target - (num + nums[pointer1] + nums[pointer2]);

                if (Math.abs(diff) < smallestDiff) {
                    sum = num + nums[pointer1] + nums[pointer2];
                    smallestDiff = Math.abs(diff);
                }

                if (nums[pointer1] + nums[pointer2] < target - num) {
                    pointer1++;
                } else if (nums[pointer1] + nums[pointer2] > target - num) {
                    pointer2--;
                } else {
                    return target;
                }

            }

        }
        return sum;

    }
}
