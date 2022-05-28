package com.canseverayberk.leetcode.easy;

public class ReverseLinkedList {

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
        ListNode reverseList = reverseList(listNode1);
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            newHead = new ListNode(head.val, newHead);
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
