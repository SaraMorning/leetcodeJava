package com.algorithm;

import java.util.Stack;

public class LC1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder("");
        int strLen = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strLen; ++i) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                stack.push(sb.length());
                sb.append(curChar);
            } else if (curChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(curChar);
                }
            } else {
                sb.append(curChar);
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}
