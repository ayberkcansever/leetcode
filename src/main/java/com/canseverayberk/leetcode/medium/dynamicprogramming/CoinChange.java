package com.canseverayberk.leetcode.medium.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        int minCount = coinChange(coins, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        return coinChangeRecur(coins, amount, dp);
    }

    public static int coinChangeRecur(int[] coins, int rem, int[] dp) {
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return -1;
        }

        if (dp[rem - 1] != 0)
            return dp[rem - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeRecur(coins, rem - coin, dp);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        dp[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[rem - 1];

    }
}
