package com.canseverayberk.leetcode.medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left != right) {
            int lh = height[left];
            int rh = height[right];

            int area = Math.min(lh, rh) * (right - left);
            max = Math.max(max, area);

            if (lh < rh) {
                left++;
            } else {
                right--;
            }

        }

        return max;
    }
}
