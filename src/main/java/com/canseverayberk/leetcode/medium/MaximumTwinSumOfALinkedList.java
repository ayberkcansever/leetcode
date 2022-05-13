package com.canseverayberk.leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */
public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(1);
        listNode3.next = listNode4;

        int pairSum = pairSum(listNode1);
    }

    public static int pairSum(ListNode head) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        int pairCount = size / 2;

        int[] pairArraySum = new int[pairCount];
        int index = 0;
        temp = head;
        while (temp != null) {
            if (index >= pairCount) {
                pairArraySum[size - index - 1] += temp.val;
            } else {
                pairArraySum[index] += temp.val;
            }
            temp = temp.next;
            index++;
        }

        int max = 0;
        for (int i : pairArraySum) {
            if (i > max)
                max = i;
        }
        return max;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
