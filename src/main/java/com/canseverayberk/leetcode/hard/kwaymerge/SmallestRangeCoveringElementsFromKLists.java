package com.canseverayberk.leetcode.hard.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
 */
public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30));
        int[] smallestRange = smallestRange(nums);
    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Num> minHeap = new PriorityQueue<>((a, b) -> a.val > b.val ? 1 : -1);

        int queueMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            Num num = new Num(list.get(0), i, 0);
            minHeap.offer(num);
            queueMax = Math.max(queueMax, num.val);
        }

        int left = minHeap.peek().val;
        int right = queueMax;
        int minWindowSize = right - left;

        while (minHeap.peek().index < nums.get(minHeap.peek().listIndex).size()) {

            Num num = minHeap.poll();
            List<Integer> list = nums.get(num.listIndex);
            int newVal = list.get(num.index);
            Num newNum = new Num(newVal, num.listIndex, num.index + 1);
            minHeap.offer(newNum);

            queueMax = Math.max(queueMax, newNum.val);

            if (queueMax - minHeap.peek().val < minWindowSize) {
                left = minHeap.peek().val;
                right = queueMax;
                minWindowSize = right - left;
            }

        }

        return new int[]{left, right};

    }

    static class Num {
        int val;
        int listIndex;
        int index;

        public Num(int val, int listIndex, int index) {
            this.val = val;
            this.listIndex = listIndex;
            this.index = index;
        }
    }

}
