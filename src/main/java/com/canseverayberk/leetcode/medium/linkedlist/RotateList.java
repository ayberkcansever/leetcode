package com.canseverayberk.leetcode.medium.linkedlist;

/*
https://leetcode.com/problems/rotate-list
 */
public class RotateList {

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
        ListNode reverseList = rotateRight(listNode1, 7);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int size = 0;
        ListNode sizePointer = head;
        while(sizePointer != null) {
            size++;
            sizePointer = sizePointer.next;
        }

        k %= size;

        ListNode current = head;
        ListNode prev = null;

        for(int i = 0; i < k; i++) {
            while(head != null) {
                if (head.next == null) {
                    prev.next = null;
                    head.next = current;
                    current = head;
                    break;
                }

                prev = head;
                head = head.next;
            }
        }

        return current;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
