package com.algorithm;

import java.util.Stack;

public class LC1312 {
    public int minInsertions(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int[][] lcs = new int[len + 1][len + 1];
        String reverseStr = new StringBuffer(s).reverse().toString();
        for (int i = 1; i <= len; ++i) {
            for (int j = 1; j <= len; ++j) {
                lcs[i][j] = s.charAt(i - 1) == reverseStr.charAt(j - 1) ? lcs[i - 1][j - 1] + 1
                        : Math.max(lcs[i][j - 1], lcs[i - 1][j]);
            }
        }
        return s.length() - lcs[len][len];
    }
}
