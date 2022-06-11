package com.canseverayberk.leetcode.easy;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_3 = new ListNode(3);
        ListNode listNode_4 = new ListNode(4);

        listNode_1.next = listNode_3;
        listNode_3.next = listNode_4;

        ListNode mergedList = mergeTwoLists(listNode1, listNode_1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode resultList = new ListNode(0);
        ListNode tail = resultList;

        ListNode pointer1 = list1;
        ListNode pointer2 = list2;

        while(pointer1 != null) {
            while (pointer2 != null && pointer2.val <= pointer1.val) {
                tail.next = new ListNode(pointer2.val);
                tail = tail.next;
                pointer2 = pointer2.next;
            }

            tail.next = new ListNode(pointer1.val);
            tail = tail.next;
            pointer1 = pointer1.next;
        }

        while(pointer2 != null) {
            tail.next = new ListNode(pointer2.val);
            tail = tail.next;
            pointer2 = pointer2.next;
        }

        return resultList.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
