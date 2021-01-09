package com.algorithm;
import java.util.*;
public class LC1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        int cur = 1;
        int curMax = intervals[0][1];
        while (cur < intervals.length) {
            if (intervals[cur][1] <= curMax) {
                count++;
            } else {
                curMax = intervals[cur][1];
            }
            cur++;
        }
        return intervals.length - count;
    }
}
