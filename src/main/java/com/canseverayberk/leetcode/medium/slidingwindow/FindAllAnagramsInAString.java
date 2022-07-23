package com.canseverayberk.leetcode.medium.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : p.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }

        int tail = 0;
        Map<Character, Integer> map2 = new HashMap<>();
        String current = "";

        for(int head = 0; head < s.length(); head++) {
            current = current.concat(String.valueOf(s.charAt(head)));
            char c = s.charAt(head);
            int count = map2.getOrDefault(c, 0);
            count++;
            map2.put(c, count);

            if (map.equals(map2)) {
                list.add(tail);
            }

            if (head - tail == p.length() - 1) {
                tail++;
                char removed = current.charAt(0);

                count = map2.getOrDefault(removed, 0);
                count--;
                if (count == 0) {
                    map2.remove(removed);
                } else {
                    map2.put(removed, count);
                }
                current = current.substring(1);
            }

        }

        return list;

    }

}
