package com.canseveayberk.leetcode.easy;

public class ClimbStairs {

    public static void main(String[] args) {
        int result = climbStairs(9);
    }

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] stair = new int[n];
        stair[0] = 1;
        stair[1] = 2;

        for (int i = 2; i < n; i++) {
            stair[i] = stair[i - 1] + stair[i - 2];
        }

        return stair[n - 1];
    }

}
