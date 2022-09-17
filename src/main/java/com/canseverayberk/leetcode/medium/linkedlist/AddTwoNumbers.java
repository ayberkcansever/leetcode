package com.canseverayberk.leetcode.medium.linkedlist;

/*
https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l21.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;

        ListNode sum = addTwoNumbers(l11, l21);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tail = new ListNode(-1);
        ListNode result = tail;

        int[] remaining = new int[] {0};
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remaining[0];
            int val = sum % 10;
            remaining[0] = sum >= 10 ? 1 : 0;

            tail.next = new ListNode(val);
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        tail = addIfNecessary(tail, l1, remaining);
        tail = addIfNecessary(tail, l2, remaining);

        if (remaining[0] > 0) {
            tail.next = new ListNode(remaining[0]);
        }

        return result.next;
    }

    private static ListNode addIfNecessary(ListNode tail, ListNode l, int[] remaining) {
        while(l != null) {
            int sum = l.val + remaining[0];
            int val = sum % 10;
            remaining[0] = sum >= 10 ? 1 : 0;

            tail.next = new ListNode(val);
            tail = tail.next;

            l = l.next;
        }
        return tail;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
