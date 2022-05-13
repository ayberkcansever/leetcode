package com.canseverayberk.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParantheses {

    public static void main(String[] args) {
        String input = "]";
        boolean valid = isValid(input);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> keySet = Set.of('(', '{', '[');

        Map<Character, Character> doorKey = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (char c : s.toCharArray()) {
            if (keySet.contains(c)) {
                stack.push(c);
            } else {
                if (doorKey.get(c) != null) {
                    if(stack.isEmpty() || stack.pop() != doorKey.get(c)) {
                        return false;
                    }
                }
            }
        }

        return stack.size() == 0;
    }
}
