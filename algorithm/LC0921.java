package com.algorithm;

import java.util.Arrays;

public class LC0921 {
    public int minAddToMakeValid(String S) {
        char[] arr = S.toCharArray();
        int needLeft = 0;
        int needRight = 0;
        for (char curChar : arr) {
            if (curChar == '(') {
                needRight++;
            } else if (needRight > 0) {
                needRight--;
            } else {
                needLeft++;
            }
        }
        return needLeft + needRight;
    }
}
