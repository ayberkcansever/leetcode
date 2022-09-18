package com.canseverayberk.leetcode;

public class KnapsackSample {

    public static void main(String[] args) {
        KnapsackSample ks = new KnapsackSample();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity == 0 || currentIndex >= profits.length)
            return 0;

        int result;
        if (weights[currentIndex] > capacity) {
            result = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        } else {
            int temp1 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
            int temp2 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
            result = Math.max(temp1, temp2);
        }

        return result;
    }
}
