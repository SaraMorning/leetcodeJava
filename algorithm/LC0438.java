package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] bit = new int[26];
        char[] pArray = p.toCharArray();
        int pLen = p.length();
        int sLen = s.length();
        for (char curChar : pArray) {
            bit[curChar - 'a']++;
        }
        for (int i = 0; i <= sLen - pLen; ++i) {
            char curChar = s.charAt(i);
            int[] curBit = Arrays.copyOf(bit, bit.length);
            int j = i;
            for (; j < sLen && j < i + pLen; ++j) {
                if (--curBit[s.charAt(j) - 'a'] < 0) {
                    break;
                }
            }
            if (j >= i + pLen) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC0438 test = new LC0438();
        test.findAnagrams("abab", "ab");
    }
}
