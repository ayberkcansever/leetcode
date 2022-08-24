package com.canseverayberk.leetcode.hard.linkedlist;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {

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

        ListNode reverseKGroup = reverseKGroup(listNode1, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        ListNode start = result;

        ListNode prev = null;
        ListNode beginning = head;

        int size = 0;
        while (head != null) {
            if (size == k) {
                prev.next = null;
                result.next = reverse(beginning);
                while (result.next != null) {
                    result = result.next;
                }

                beginning = head;
                size = 0;
            }
            prev = head;
            head = head.next;
            size++;
        }

        if (size > 0) {
            if (size == k)
                result.next = reverse(beginning);
            else
                result.next = beginning;
        }

        return start.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
