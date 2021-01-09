package com.algorithm;

import java.util.*;

public class LC0078 {
    //依次往每一个集合里面添加元素i，生成新增子集加入到result
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        result.add(list);
        for (int num : nums) {
            List<List<Integer>> newSubSet = new ArrayList<>();
            for (List<Integer> cur : result) {
                newSubSet.add(new ArrayList<Integer>(cur) {{
                    cur.add(num);
                }});
            }
            result.addAll(newSubSet);
        }
        return result;
    }

    //回溯法，添加或者不添加当前元素
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        backTrace(nums, 0, list, result);
        return result;
    }

    public void backTrace(int[] nums, int start, List<Integer> curList, List<List<Integer>> result) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }
        int length = nums.length;
        for (int index = start; index < length; ++index) {
            curList.add(nums[index]);
            backTrace(nums, index + 1, curList, result);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
