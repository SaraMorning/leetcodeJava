package com.algorithm;

import java.util.Arrays;
import java.util.Stack;

public class LC0856 {
    public int scoreOfParentheses(String S) {
        char[] arr = S.toCharArray();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (char curChar : arr) {
            if (curChar == '(') {
                stack.push(res);
                res = 0;
            } else {
                res = stack.peek() + Math.max(res * 2, 1);
                stack.pop();
            }
        }
        return res;
    }
}
