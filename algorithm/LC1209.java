package com.algorithm;

import java.util.*;

public class LC1209 {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.isEmpty() || s.length() < k) {
            return s;
        }
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder(s);
        for (int index = 0; index < sb.length(); ++index) {
            if (stack.isEmpty() || sb.charAt(index) != sb.charAt(index - 1)) {
                stack.push(1);
            } else {
                int newCount = stack.pop() + 1;
                if (newCount == k) {
                    sb.delete(index - k + 1, index + 1);
                    index = index-k;
                } else {
                    stack.push(newCount);
                }
            }
        }
        return sb.toString();
    }
}
