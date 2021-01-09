package com.algorithm;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class LC0056 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public int[][] merge2(int[][] intervals) {
        List<Integer> s = new ArrayList<>();

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<Integer> nums = Arrays.stream(intervals)
                .flatMapToInt(Arrays::stream).boxed()
                .collect(toList());

        for (int n : nums) {
            boolean less = false;
            while (!s.isEmpty() && n < s.get(s.size() - 1)) {
                s.remove(s.size() - 1);
                less = true;
            }
            if (!less) {
                s.add(n);
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < s.size(); ++i) {
            result.add(new int[]{s.get(i), s.get(i + 1)});
        }

        return (int[][]) result.toArray();
    }
}
