package com.algorithm;

public class LC0718 {
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int[][] lcq = new int[A.length+1][B.length+1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= B.length; ++j) {
                lcq[i][j] = (A[i-1] == B[j-1]) ? lcq[i-1][j-1] + 1 : 0;
                maxLen = Math.max(maxLen, lcq[i][j]);
            }
        }
        return maxLen;
    }
}
