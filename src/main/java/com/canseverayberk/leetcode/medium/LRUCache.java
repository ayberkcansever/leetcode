package com.canseverayberk.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    static class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LruCache {
        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;
        private int capacity;

        public LruCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null)
                return -1;

            remove(node);
            addFirst(node);

            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                cache.put(key, node);
            } else {
                node.value = value;
            }
            remove(node);
            addFirst(node);

            if (cache.keySet().size() > capacity) {
                Node evictedNode = tail.prev;
                cache.remove(evictedNode.key);
                remove(tail.prev);
            }
        }

        private void remove(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        private void addFirst(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }
    }

}
