package com.canseverayberk.leetcode.easy.fastslowpointer;

/*
https://leetcode.com/problems/happy-number
 */
public class HappyNumber {

    public static void main(String[] args) {
        boolean happy = isHappy(19);
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = total(slow);
            fast = total(total(fast));
            if (slow == 1) {
                return true;
            }
        } while (fast != slow);
        return false;
    }

    private static int total(int n) {
        String s = String.valueOf(n);
        int total = 0;
        for(char c : s.toCharArray()) {
            int val = Integer.parseInt(String.valueOf(c));
            int square = val * val;
            total += square;
        }
        return total;
    }
}
