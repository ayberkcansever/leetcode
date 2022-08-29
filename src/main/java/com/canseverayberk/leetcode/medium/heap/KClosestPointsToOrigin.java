package com.canseverayberk.leetcode.medium.heap;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/k-closest-points-to-origin
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int[][] kClosest = kClosest(points, 2);
    }

    public static int[][] kClosest(int[][] points, int k) {
        if (points.length == 0)
            return new int[][]{};

        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> a.distance() > b.distance() ? -1 : 1);

        for (int i = 0; i < k; i++) {
            queue.offer(new Point(points[i]));
        }

        for (int i = k; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (distance < queue.peek().distance()) {
                queue.poll();
                queue.add(new Point(points[i]));
            }
        }

        int[][] results = new int[k][2];
        for (int i = 0; i < k; i++) {
            results[i] = queue.poll().point;
        }
        return results;

    }

    static class Point {
        int[] point;

        public Point(int[] point) {
            this.point = point;
        }

        public double distance() {
            return point[0] * point[0] + point[1] * point[1];
        }
    }
}
