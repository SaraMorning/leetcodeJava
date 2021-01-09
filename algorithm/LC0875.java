package com.algorithm;

import java.util.Arrays;

public class LC0875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Arrays.stream(piles).summaryStatistics().getMax();
        if (piles.length == H) {
            return max;
        }
        int left = 1;
        while (left < max) {
            int mid = left + (max - left) / 2;
            if (isPossible(piles, H, mid)) {
                max = mid;
            } else {
                left = mid + 1;
            }
        }
        return max;
    }
    private boolean isPossible(int[] piles, int H ,int curK) {
        int sum = Arrays.stream(piles).map(pile->pile % curK == 0 ? pile / curK : pile / curK + 1).sum();
        int sum2 = Arrays.stream(piles).map(pile->pile % curK == 0 ? pile / curK : pile / curK + 1)
                .reduce(0, (a,b)->{return a+b;});
        return sum <= H;
    }
}
