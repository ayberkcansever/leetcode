package com.canseverayberk.leetcode.easy.twopointers;

/*
https://leetcode.com/problems/squares-of-a-sorted-array
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {-4,-1,0,3,10};
        int[] sortedSquares = sortedSquares(nums);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int head = nums.length - 1, tail = 0, index = nums.length - 1;
        while(index >= 0) {

            if( Math.abs(nums[head]) >= Math.abs(nums[tail]) ) {
                result[index] = nums[head] * nums[head];
                head--;
            } else {
                result[index] = nums[tail] * nums[tail];
                tail++;
            }
            index--;
        }

        return result;

    }
}
