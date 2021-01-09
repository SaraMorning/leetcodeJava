package com.Exam;

import java.util.*;

public class Exam051502 {
    public int getMinOperateCount(int[] orders) {
        List<Integer> list = new ArrayList<>();
        int sumCount = 0;
        for (int curOrder : orders) {
            int insertIndex = (int) list.stream().filter(order -> order < curOrder).count();
            sumCount += (Math.min(insertIndex, (list.size() - insertIndex))) * 2 + 1;
            list.add(insertIndex, curOrder);
        }
        return sumCount;
    }

    public static void main(String[] args) {
        Exam051502 test = new Exam051502();
        int[] arr = new int[]{6, 2, 10, 4, 3, 5};
        int result = test.getMinOperateCount(arr);
        System.out.println(result);
    }
}
