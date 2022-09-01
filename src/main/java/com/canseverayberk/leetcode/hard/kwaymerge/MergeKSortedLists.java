package com.canseverayberk.leetcode.hard.kwaymerge;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l14 = new ListNode(4);
        l11.next = l14;
        ListNode l15 = new ListNode(5);
        l14.next = l15;

        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        l21.next = l23;
        ListNode l24 = new ListNode(4);
        l23.next = l24;

        ListNode l32 = new ListNode(2);
        ListNode l36 = new ListNode(6);
        l32.next = l36;

        ListNode mergedListNode = mergeKLists(new ListNode[]{l11, l21, l32});
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val > b.val ? 1 : -1);
        for(ListNode node : lists) {
            if (node == null)
                continue;
            queue.offer(node);
            while(node.next != null) {
                queue.offer(node.next);
                node = node.next;
            }
        }

        ListNode result = null;
        ListNode prev = null;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (result == null) {
                result = node;
            } else {
                prev.next = node;
            }
            prev = node;
            prev.next = null;
        }

        return result;
    }

    static class ListNode {
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
