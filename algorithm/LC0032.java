package com.algorithm;

import java.util.Stack;

public class LC0032 {
    public int longestValidParentheses(String s) {
        int strLen = s.length();
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < strLen; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    result = stack.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    public int longestValidParentheses2(String s) {
        int strLen = s.length();
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < strLen; ++i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (left == right) {
                res = Math.max(right * 2, res);
            }
        }
        left = 0;
        right = 0;
        for (int i = strLen - 1; i > 0; --i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (right < left) {
                left = 0;
                right = 0;
            } else if (left == right) {
                res = Math.max(left * 2, res);
            }
        }
        return res;
    }
}
