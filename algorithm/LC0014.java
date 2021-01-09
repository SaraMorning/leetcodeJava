package com.algorithm;

import java.util.Arrays;

public class LC0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        int resultLen = result.length();
        int arrLen = strs.length;
        for (int i = 1; i < arrLen; ++i) {
            int lenTmpStr = strs[i].length();
            int j = 0;
            for (; j < resultLen && j < lenTmpStr; ++j) {
                if (strs[i].charAt(j) != result.charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return "";
            }
            result = strs[i].substring(0, j);
            resultLen = result.length();
        }
        return result;
    }

    public String longestCommonPrefix02(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int maxLen = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();
        for (int i = 0; i < maxLen; ++i) {
            char curCharacter = strs[0].charAt(i);
            boolean isSame = true;
            for (String curStr : strs) {
                if (curStr.charAt(i) != curCharacter) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, maxLen);
    }
}
