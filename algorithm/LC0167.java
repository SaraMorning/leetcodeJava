package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int left = 0, right = len - 1; left < right; ) {
            int curSum = numbers[left] + numbers[right];
            if (curSum < target) {
                left++;
            } else if (curSum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[0];
    }
}
