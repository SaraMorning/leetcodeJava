package com.algorithm;

public class LC0557 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int size = strs.length;
        for (int loop = 0; loop < size; loop++) {
            strs[loop] = new StringBuffer(strs[loop]).reverse().toString();
        }
        StringBuffer result = new StringBuffer("");
        for (int loop = 0; loop < size; loop++) {
            if(loop == 0) {
                result.append(strs[loop]);
            } else {
                result.append(" " + strs[loop]);
            }
        }
        return result.toString();
    }
}
