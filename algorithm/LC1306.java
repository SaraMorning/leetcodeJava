package com.algorithm;

public class LC1306 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visit = new boolean[arr.length];
        return check(visit, arr, start);
    }
    private boolean check(boolean[] visit, int[] arr, int curStart) {
        if (curStart < 0 || curStart >= arr.length) {
            return false;
        }
        if (visit[curStart]) {
            return false;
        }
        if (arr[curStart] == 0) {
            return true;
        }
        visit[curStart] = true;
        return check(visit, arr, curStart + arr[curStart])
                || check(visit, arr, curStart - arr[curStart]);
    }
}
