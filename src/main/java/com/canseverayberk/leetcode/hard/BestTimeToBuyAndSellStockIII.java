package com.canseverayberk.leetcode.hard;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int maxProfit = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] profitsForward = profitsForward(prices);
        int[] profitsBackward = profitsBackward(prices);

        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, profitsForward[i] + profitsBackward[i]);
        }

        return maxProfit;
    }

    private static int[] profitsBackward(int[] prices) {
        int maxPrice = prices[prices.length - 1];
        int maxProfit = 0;
        int[] profits = new int[prices.length];
        for(int i = prices.length - 2; i > -1; i--){
            if(prices[i] > maxPrice)
                maxPrice = prices[i];

            int profit = maxPrice - prices[i];
            if (profit > maxProfit)
                maxProfit = profit;
            profits[i] = maxProfit;
        }
        return profits;
    }

    private static int[] profitsForward(int[] prices) {
        int[] profits = new int[prices.length];
        profits[0] = 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            int profit = prices[i] - minPrice;
            if (profit > maxProfit)
                maxProfit = profit;
            profits[i] = maxProfit;
        }

        return profits;
    }

}
