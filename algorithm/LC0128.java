package com.algorithm;
import java.util.*;
public class LC0128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int maxLen = 1;
        int startPos = 0;
        int endPos = 1;
        for(; endPos < length; ++endPos) {
            if (nums[endPos] - nums[endPos - 1] == 0) {
                ++startPos;
                continue;
            }
            if (nums[endPos] - nums[endPos - 1] != 1) {
                int curMaxLen = endPos - startPos;
                startPos = endPos;
                if (maxLen < curMaxLen) {
                    maxLen = curMaxLen;
                }
            }
        }
        if(endPos - startPos > maxLen) {
            maxLen = endPos - startPos;
        }
        return maxLen;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
