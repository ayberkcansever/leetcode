package com.canseverayberk.leetcode.medium.slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum
 */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minSubArrayLen = minSubArrayLen(target, nums);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0)
            return 0;

        int minLength = Integer.MAX_VALUE;
        int tail = 0;

        int sum = 0;
        for (int head = 0; head < nums.length; head++) {
            sum += nums[head];
            if (sum >= target) {
                minLength = Math.min(minLength, (head - tail) + 1);
                while(sum > target) {
                    sum -= nums[tail];
                    tail++;
                    if (sum >= target) {
                        minLength = Math.min(minLength, (head - tail) + 1);
                    }
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
