package com.algorithm;

public class LC0041 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        for (int curPos = 0; curPos < length; ++curPos) {
            if (curPos != nums[curPos] - 1) {
                while ((nums[curPos] > 0) && (nums[curPos] <= length) && (curPos != nums[curPos] - 1)
                        && (nums[curPos] != nums[nums[curPos] - 1])) {
                    int switchPos = nums[curPos] - 1;
                    int switchNum = nums[switchPos];
                    nums[switchPos] = nums[curPos];
                    nums[curPos] = switchNum;
                }
            }
        }
        int index = 0;
        for (; index < length; ++index) {
            if (index != nums[index] - 1) {
                break;
            }
        }
        return index + 1;
    }
}
