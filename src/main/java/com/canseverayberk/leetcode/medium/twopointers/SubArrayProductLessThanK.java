package com.canseverayberk.leetcode.medium.twopointers;

/*
https://leetcode.com/problems/subarray-product-less-than-k
 */
public class SubArrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = new int[] {2,5,6,10};
        int numSubarrayProductLessThanK = numSubarrayProductLessThanK(nums, 100);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int tail = 0;
        int product = 1;
        for (int head = 0; head < nums.length; head++) {
            product *= nums[head];
            while(tail <= head && product >= k){
                product /= nums[tail++];
            }
            count += (head-tail+1);
        }

        return count;

    }
}
