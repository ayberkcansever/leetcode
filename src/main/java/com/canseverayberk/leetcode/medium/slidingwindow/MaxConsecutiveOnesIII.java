package com.canseverayberk.leetcode.medium.slidingwindow;

/*
https://leetcode.com/problems/max-consecutive-ones-iii
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k = 8;
        int longestOnes = longestOnes(nums, k);
    }

    public static int longestOnes(int[] nums, int k) {
        if (nums.length <= k) {
            return nums.length;
        }

        int maxLength = 0;
        int tail = 0;
        int zeroCount = 0;

        for(int head = 0; head < nums.length; head++) {
            if (nums[head] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                int count = 0;
                while(zeroCount > k) {
                    if (nums[tail] == 0) {
                        zeroCount--;
                    }
                    tail++;
                    count++;
                }
                maxLength = Math.max(maxLength, count - 1);
            } else {
                maxLength = Math.max(maxLength, head - tail + 1);
            }
        }

        return maxLength;
    }
}
