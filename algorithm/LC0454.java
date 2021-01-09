package com.algorithm;

import java.util.*;

public class LC0454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> mapAB = new HashMap<>();
        Map<Integer, Integer> mapCD = new HashMap<>();

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                putMap(mapAB, A[i] + B[j]);
                putMap(mapCD, C[i] + D[j]);
            }
        }
        int result = 0;
        for(Integer curKey : mapAB.keySet()) {
            result += mapAB.get(curKey) * mapCD.getOrDefault(-curKey, 0);
        }
        return result;
    }

    private void putMap(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
