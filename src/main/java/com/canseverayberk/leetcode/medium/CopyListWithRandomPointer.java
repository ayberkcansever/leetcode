package com.canseverayberk.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node7 = new Node(7);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node13 = new Node(13);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        Node copiedList = copyRandomList(node7);
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Integer> nodeIndexMap = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node copy = new Node(0);
        Node tail = copy;

        int index = 0;
        Node tempHead = head;
        while (tempHead != null) {
            nodeIndexMap.put(tempHead, index);
            tempHead = tempHead.next;
            index++;
        }

        tempHead = head;
        index = 0;
        while (tempHead != null) {
            Node newNode = new Node(tempHead.val);
            nodeMap.put(index, newNode);

            tail.next = newNode;
            tail = tail.next;

            tempHead = tempHead.next;
            index++;
        }

        Node copiedList = copy.next;
        index = -1;
        while (copy != null) {
            if (index >= 0) {
                copy.random = nodeMap.get(nodeIndexMap.get(head.random));
                head = head.next;
            }
            copy = copy.next;
            index++;
        }
        return copiedList;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
