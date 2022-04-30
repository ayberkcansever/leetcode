package com.canseverayberk.leetcode.easy;

public class FirstBadVersion {

    public static void main(String[] args) {
        int firstBadVersion = firstBadVersion(5);
    }

    public static int firstBadVersion(int n) {
        int temp = 0;
        int middle = n / 2;
        while(temp != middle) {
            if (isBadVersion(middle)) {
                middle = temp + (middle - temp) / 2;
            } else {
                temp = middle;
                middle = middle + (n - middle) / 2;
            }
        }
        return middle + 1;
    }

    public static boolean isBadVersion(int n) {
        return n >= 4;
    }

}
