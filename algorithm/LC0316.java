package com.algorithm;

import java.util.*;

public class LC0316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> mapRemain = new HashMap<>();
        for (char curChar : chars) {
            mapRemain.put(curChar, mapRemain.containsKey(curChar) ? mapRemain.get(curChar) + 1 : 1);
        }
        Set<Character> inSet = new HashSet<>();
        for (char curChar : chars) {
            mapRemain.put(curChar, mapRemain.get(curChar) - 1);
            if (inSet.contains(curChar)) {
                continue;
            }
            while (!stack.isEmpty() && curChar < stack.peek() && mapRemain.get(curChar) > 0) {
                inSet.remove(stack.pop());
            }
            stack.push(curChar);
            inSet.add(curChar);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
