package com.canseverayberk.leetcode.hard.twoheaps;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/find-median-from-data-stream
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        double median = medianFinder.findMedian();

        medianFinder.addNum(2);
        median = medianFinder.findMedian();

        medianFinder.addNum(3);
        median = medianFinder.findMedian();

        medianFinder.addNum(4);
        median = medianFinder.findMedian();
    }

    static class MedianFinder {

        PriorityQueue<Integer> leftQueue;
        PriorityQueue<Integer> rightQueue;

        public MedianFinder() {
            leftQueue = new PriorityQueue<>((a, b) -> b - a); // 3,2,1
            rightQueue = new PriorityQueue<>((a, b) -> a - b); // 4,5,6
        }

        public void addNum(int num) {
            if (leftQueue.size() == 0) {
                leftQueue.add(num);
                return;
            }

            if (rightQueue.size() == 0) {
                if(num > leftQueue.peek()) {
                    rightQueue.add(num);
                }
                else {
                    rightQueue.add(leftQueue.poll());
                    leftQueue.add(num);
                }
                return;
            }

            int leftMax = leftQueue.peek();
            int rightMin = rightQueue.peek();

            if (leftMax >= num) {
                leftQueue.add(num);
            } else if (num >= rightMin) {
                rightQueue.add(num);
            } else {
                rightQueue.add(num);
            }

            while(leftQueue.size() - rightQueue.size() > 0) {
                rightQueue.add(leftQueue.poll());
            }
            while(rightQueue.size() - leftQueue.size() > 1) {
                leftQueue.add(rightQueue.poll());
            }
        }

        public double findMedian() {
            int size = leftQueue.size() + rightQueue.size();
            if (size == 1)
                return leftQueue.peek();
            if (size % 2 == 1) {
                return (double) rightQueue.peek();
            } else {
                return ((double) leftQueue.peek() + (double) rightQueue.peek()) / 2;
            }
        }

    }
}
