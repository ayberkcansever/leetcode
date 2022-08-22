package com.canseverayberk.leetcode.easy.fastslowpointer;

/*
https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node3.next = node2;
        ListNode node0 = new ListNode(0);
        node2.next = node0;
        ListNode node4 = new ListNode(4);
        node0.next = node4;
        node4.next = node2;

        boolean hasCycle = hasCycle(node3);
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
