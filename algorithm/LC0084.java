package com.algorithm;

import java.util.*;

public class LC0084 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; ++i) {
            int curMax = 0;
            while (!stack.isEmpty() && stack.peek() > heights[i]) {
                curMax = Math.max(stack.peek(), curMax);
                int cur = stack.pop();
                result = Math.max((curMax-cur +1) * heights[cur], result);
            }
            stack.push(i);
        }
        return result;
    }
}
