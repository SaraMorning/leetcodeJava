package com.algorithm;
import java.util.*;
public class LC0046 {
    public void permutation(List<List<Integer>> result, int[] nums, int start) {
        if(start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            int tmp =  nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permutation(result, nums, (start+1));
            tmp =  nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        permutation(result, nums, 0);
        return result;
    }
}
