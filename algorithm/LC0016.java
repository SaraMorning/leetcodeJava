package com.algorithm;

import java.util.Arrays;

public class LC0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        for (int i = 0; i < length - 2; ++i) {
            if (nums[i] * 3 > target) {
                return Math.min(closest, nums[i] + nums[i + 1] + nums[i + 2]);
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int tmpClosest = nums[i] + nums[left] + nums[right];
                int tmpDiff = Math.abs(target - tmpClosest);
                if (tmpDiff < diff) {
                    diff = tmpDiff;
                    closest = tmpClosest;
                }
                if (tmpClosest < target) {
                    left++;
                } else if (tmpClosest > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
