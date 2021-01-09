package com.algorithm;

public class LC1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] lcs = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= B.length; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[A.length][B.length];
    }
}
