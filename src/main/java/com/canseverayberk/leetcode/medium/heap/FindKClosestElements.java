package com.canseverayberk.leetcode.medium.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/find-k-closest-elements
 */
public class FindKClosestElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> closestElements = findClosestElements(arr, 4, 3);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b > a ? 1 : -1);

        for (int i = 0; i < k; i++) {
            int diff = x - arr[i];
            queue.offer(diff);
        }

        for (int i = k; i < arr.length; i++) {
            if (Math.abs(x - arr[i]) < queue.peek()) {
                queue.poll();
                queue.offer(x - arr[i]);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(x - queue.poll());
        }

        return result;

    }
}
