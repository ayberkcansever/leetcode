package com.canseverayberk.leetcode.medium.linkedlist;

/*
https://leetcode.com/problems/reverse-linked-list-ii
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode reverseList = reverseBetween(listNode1, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int l, int r) {
        if (head.next == null || r == l)
            return head;

        ListNode result = head;
        ListNode subStart = null;
        ListNode sub = null;
        ListNode left = null;
        ListNode right = null;

        int pos = 1;
        ListNode prev = null;
        while(head != null) {
            if (pos == l) {
                left = prev;
                subStart = head;

                sub = head;
                if (left != null)
                    left.next = null;
            } else if (pos == r) {
                right = head.next;
                sub = head;
                sub.next = null;
            } else if (pos > l && pos < r) {
                System.out.println("3-" + pos);
                sub.next = head;
                sub = sub.next;
            }

            prev = head;
            head = head.next;
            pos++;
        }

        if (subStart == null) {
            return result;
        }

        ListNode reversed = reverse(subStart);
        ListNode rEnd = reversed;
        while(rEnd.next != null) {
            rEnd = rEnd.next;
        }

        rEnd.next = right;
        if (left != null)
            left.next = reversed;
        else
            return reversed;

        return result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
