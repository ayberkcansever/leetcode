package com.canseverayberk.leetcode.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sort-characters-by-frequency
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        String sorted = frequencySort(s);
    }

    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }

        PriorityQueue<CharClass> queue = new PriorityQueue<>((a, b) -> a.count > b.count ? -1 : 1);
        for(Character key : map.keySet()) {
            queue.offer(new CharClass(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            CharClass charClass = queue.poll();
            for(int i = 0; i < charClass.count; i++) {
                sb.append(charClass.c);
            }
        }

        return sb.toString();
    }

    static class CharClass {
        char c;
        int count;

        public CharClass(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
