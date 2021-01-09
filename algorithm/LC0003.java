package com.algorithm;
import java.util.*;
public class LC0003 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int strLen = s.length();
        for (int i = 0; i < strLen; ++i) {
            set.clear();
            for (int right = i; right < strLen; ++right) {
                if (set.contains(s.charAt(right))) {
                    break;
                }
                set.add(s.charAt(right));
            }
            maxLen = Math.max(maxLen, set.size());
            if (i + maxLen >= strLen) {
                break;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int strLen = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int curStart = 0; curStart < strLen; ++curStart) {
            map.clear();
            map.put(s.charAt(curStart), 1);
            int curEnd = curStart + 1;
            for (; curEnd < strLen;) {
                Integer charCount = map.get(s.charAt(curEnd));
                if (charCount == null) {
                    map.put(s.charAt(curEnd), 1);
                    ++curEnd;
                } else {
                    break;
                }
            }
            int curLen = curEnd - curStart;
            if(curLen > maxLen) {
                maxLen = curLen;
            }
            if (strLen - (curStart + 1) < maxLen) {
                break;
            }
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
