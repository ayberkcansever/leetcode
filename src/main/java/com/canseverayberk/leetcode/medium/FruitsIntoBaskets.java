package com.canseverayberk.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = new int[]{1, 2, 3, 2, 2};
        int totalFruit = totalFruit(fruits);
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }

        int maxTotalFruitCount = 0;

        for (int i = 0; i < fruits.length; i++) {

            if (maxTotalFruitCount >= fruits.length - i)
                return maxTotalFruitCount;

            Set<Integer> fruitTreeSet = new HashSet<Integer>();
            int totalFruitCount = 0;

            for (int j = i; j < fruits.length; j++) {
                fruitTreeSet.add(fruits[j]);

                if (fruitTreeSet.size() <= 2) {
                    totalFruitCount++;
                    maxTotalFruitCount = Math.max(totalFruitCount, maxTotalFruitCount);
                } else {
                    maxTotalFruitCount = Math.max(totalFruitCount, maxTotalFruitCount);
                    totalFruitCount = 0;
                    fruitTreeSet = new HashSet<>();
                    break;
                }

            }

        }

        return maxTotalFruitCount;

    }
}
