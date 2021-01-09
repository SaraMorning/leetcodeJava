package com.algorithm;

import java.util.Arrays;

public class LC0322 {
    public int coinChange(int[] coins, int amount) {
        int row[] = new int[amount + 1];
        Arrays.fill(row, amount + 1);
        row[0] = 0;
        int coinsCount = coins.length;
        for (int index = 0; index < coinsCount; ++index) {
            for (int j = coins[index]; j <= amount; ++j) {
                row[j] = Math.min(row[j], row[j - coins[index]] + 1);
            }
        }
        return row[amount] == amount + 1 ? -1 : row[amount];
    }
}
