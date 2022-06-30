package com.canseverayberk.leetcode.hard;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
    }

    public static int trap(int[] height) {

        int[] maxLeftHeight = new int[height.length];
        maxLeftHeight[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i - 1]);
        }

        int[] maxRightHeight = new int[height.length];
        maxRightHeight[maxRightHeight.length - 1] = 0;
        for (int i = maxRightHeight.length - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i + 1]);
        }

        int totalTrapped = 0;
        for (int i = 0; i < maxLeftHeight.length; i++) {
            if (height[i] < maxLeftHeight[i] && height[i] < maxRightHeight[i]) {
                int trapped = Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
                totalTrapped += trapped;
            }
        }

        return totalTrapped;
    }

}
