package com.canseverayberk.leetcode.hard;

import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            List<Integer> profits = maxProfitOfArrays(prices, i);
            int i1 = profits.get(0);
            int i2 = profits.get(1);
            if (i1 + i2 > maxProfit) {
                maxProfit = i1 + i2;
            }
        }

        return maxProfit;
    }

    private static List<Integer> maxProfitOfArrays(int[] prices, int index) {
        if (prices.length == 0)
            return List.of(0, 0);
        int minBeforeFirst = prices[0];
        int minBeforeSecond = Integer.MAX_VALUE;
        int maxProfitFirst = 0;
        int maxProfitSecond = 0;
        for (int i = 0; i < prices.length; i++) {
            int dayValue = prices[i];
            if (i <= index) {
                int profit = dayValue - minBeforeFirst;
                if (profit > maxProfitFirst)
                    maxProfitFirst = profit;
                if (dayValue < minBeforeFirst)
                    minBeforeFirst = dayValue;
            } else {
                int profit = dayValue - minBeforeSecond;
                if (profit > maxProfitSecond)
                    maxProfitSecond = profit;
                if (dayValue < minBeforeSecond) {
                    minBeforeSecond = dayValue;
                }
            }
        }
        return List.of(maxProfitFirst, maxProfitSecond);
    }

}
