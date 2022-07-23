package com.canseverayberk.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        int max = 0, tail = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int fruit : fruits) {
            int currentCount = map.getOrDefault(fruit, 0);
            currentCount++;
            map.put(fruit, currentCount);

            if (map.values().size() <= 2) {
                int sum = 0;
                for (Integer value : map.values()) {
                    sum += value;
                }
                max = Math.max(max, sum);
            } else {
                int c = map.get(fruits[tail]);
                if (c == 1) {
                    map.remove(fruits[tail]);
                } else {
                    c--;
                    map.put(fruits[tail], c);
                }
                tail++;
            }
        }
        return max;

    }
}
