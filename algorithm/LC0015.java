package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int numsCount = nums.length;
        for (int index = 0; index < (numsCount - 2); ++index) {
            if (nums[index] > 0) {
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            for (int left = index + 1, right = numsCount - 1; left < right; ) {
                int curSum = nums[index] + nums[left] + nums[right];
                if (curSum == 0) {
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (curSum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int count = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count - 2; ++i) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int reserve = -nums[i];
            int left = i + 1;
            int right = count - 1;
            while (left < right) {
                if (nums[left] + nums[right] < reserve) {
                    left++;
                } else if (nums[left] + nums[right] > reserve) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
