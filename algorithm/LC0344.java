package com.algorithm;

public class LC0344 {
    public void reverseString(char[] s) {
        reverseHelp(s, 0, s.length-1);
    }
    public void reverseHelp(char[] s, int left, int right) {
        if(left >= right) {
            return;
        }
        char tmp = s[right];
        s[right] = s[left];
        s[left] = tmp;
        reverseHelp(s, left+1, right-1);
        return;
    }
}
