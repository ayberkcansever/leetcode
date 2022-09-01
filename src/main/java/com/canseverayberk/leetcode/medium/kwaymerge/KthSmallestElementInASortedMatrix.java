package com.canseverayberk.leetcode.medium.kwaymerge;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int kthSmallest = kthSmallest(matrix, 8);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int heapSize = 0;
        for (int[] list : matrix) {
            for (int i : list) {
                maxHeap.offer(i);
                heapSize++;
                if (heapSize == k)
                    break;
            }
            if (heapSize == k)
                break;
        }

        int index = 0;
        for (int[] list : matrix) {
            for (int i : list) {
                index++;
                if (index > heapSize) {
                    if (i < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(i);
                    }
                }
            }

        }
        return maxHeap.peek();
    }

}
