package com.algorithm;

import java.util.Arrays;

public class LC0518 {
    public int change(int amount, int[] coins) {
        int[] row = new int[amount+1];
        Arrays.fill(row, 0);
        row[0] = 1;
        for (int c:coins) {
            for(int j = c; j <= amount; ++j) {
                row[j] = row[j] + row[j-c];
            }
        }
        return row[amount];
    }
}
