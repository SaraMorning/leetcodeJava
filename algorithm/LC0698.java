package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC0698 {
    int target;
    int[] nums;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k == 0) {
            return false;
        }
        this.target = sum / k;
        visited = new boolean[nums.length];

        List<Integer> tmp = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        Collections.reverse(tmp);
        this.nums = tmp.stream().mapToInt(Integer::valueOf).toArray();

        return check(0, target, k);

//        if (nums[nums.length -1] > target) {
//            return false;
//        }
//        int groupCount = k;
//        int numIndex = nums.length-1;
//        while (numIndex >= 0 && nums[numIndex] == target) {
//            groupCount--;
//        }

    }

    private boolean check(int start,int curTarget, int k) {
        if (k == 1) {
            return true;
        }
        if (curTarget < 0) {
            return false;
        }
        if (curTarget == 0) {
            return check(0, target, k-1);
        }
        for (int index = start; index < nums.length; ++index) {
            if (!visited[index]) {
                visited[index] = true;
                if (check(index + 1, curTarget - nums[index], k)) {
                    return true;
                }
                visited[index] = false;
            }
        }
        return false;
    }
}
