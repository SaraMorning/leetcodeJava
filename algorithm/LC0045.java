package com.algorithm;

import java.util.Arrays;

public class LC0045 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            int end = i + nums[i] < nums.length ? i + nums[i] : nums.length - 1;
            for (int j = i + 1; j <= end; ++j) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[nums.length - 1];
    }
}
