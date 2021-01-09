package com.algorithm;

import java.util.Arrays;

public class LC0416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] row = new boolean[target+1];
        Arrays.fill(row, false);
        row[0] = true;
        int rowLen = nums.length;
        for (int index = 0; index < rowLen; ++index) {
            for (int j = target; j >=nums[index]; --j) {
                row[j] = row[j] || row[j-nums[index]];
            }
        }
        return row[target];
    }
}
