package com.canseverayberk.leetcode.easy;

import java.util.Stack;

/*
https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        boolean backspaceCompare = backspaceCompare(s, t);
    }

    public static boolean backspaceCompare(String s, String t) {
        return merge(s).equals(merge(t));
    }

    private static String merge(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : chars) {
            if (c == '#') {
                if (!stack.empty())
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        while(!stack.empty()) {
            Character c = stack.pop();
            result = result.concat(c.toString());
        }
        return result;
    }
}
