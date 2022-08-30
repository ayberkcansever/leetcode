package com.canseverayberk.leetcode.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/reorganize-string
 */
public class ReorganizeString {

    public static void main(String[] args) {
        String s = "vvlov";
        String reorganizedString = reorganizeString(s);
    }

    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for(char c : chars) {
            int count = map.getOrDefault(c, 0);
            ++count;
            map.put(c, count);
        }

        PriorityQueue<CharClass> queue = new PriorityQueue<>((a, b) -> a.count > b.count ? -1 : 1);

        for(char c : map.keySet()) {
            queue.offer(new CharClass(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            CharClass c = queue.poll();

            if (sb.length() > 0 && sb.lastIndexOf("" + c.c) == sb.length() - 1) {
                if (queue.size() == 0)
                    return "";
                CharClass c2 = queue.poll();
                sb.append(c2.c);
                c2.count--;
                if (c2.count > 0)
                    queue.offer(c2);
                queue.offer(c);
                continue;
            }

            sb.append(c.c);
            c.count--;
            if (c.count > 0)
                queue.offer(c);
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
