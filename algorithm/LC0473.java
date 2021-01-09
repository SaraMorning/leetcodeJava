package com.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class LC0473 {
    class Solution {
        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length < 4) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            if (sum % 4 != 0) {
                return false;
            }
            int target = sum / 4;

            boolean[] visit = new boolean[nums.length];
/*            List<Integer> tmp = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
            Collections.reverse(tmp);
            int[] newNums = tmp.stream().mapToInt(i->i).toArray();*/



            List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            tmp.sort(Comparator.comparingInt(Integer::intValue).reversed());
            int[] newNums = tmp.stream().mapToInt(i->i).toArray();


            return dfsCheck(newNums, visit, 0, target, target, 4);
        }
        private boolean dfsCheck(int[] nums, boolean[] visit, int start, int target, int curTargetReserve, int kthGroup) {
            if (curTargetReserve < 0) {
                return false;
            }
            if (kthGroup == 1) {
                return true;
            }
            if (curTargetReserve == 0) {
                return dfsCheck(nums, visit, 0, target, target, kthGroup - 1);
            }
            for (int index = start; index < nums.length; ++index) {
                if (visit[index] == true) {
                    continue;
                }
                visit[index] = true;
                if (dfsCheck(nums, visit, index + 1, target, curTargetReserve - nums[index], kthGroup)) {
                    return true;
                }
                visit[index] = false;
            }
            return false;
        }
    }
}
