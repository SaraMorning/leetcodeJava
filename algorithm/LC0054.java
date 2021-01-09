package com.algorithm;
import java.util.*;
public class LC0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int rowUp = 0;
        int rowDown = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1 ;
        List<Integer> result = new ArrayList<>();
        while (rowUp <= rowDown && left <= right) {
            if (rowUp <= rowDown) {
                int cur = left;
                while (cur <= right) {
                    result.add(matrix[rowUp][cur]);
                    cur++;
                }
            }
            rowUp++;
            if (left <= right) {
                int cur = rowUp;
                while (cur <= rowDown) {
                    result.add(matrix[cur][right]);
                    cur++;
                }
            }
            right--;
            if (rowUp <= rowDown) {
                int cur = right;
                while (cur >= left) {
                    result.add(matrix[rowDown][cur]);
                    cur--;
                }
            }
            rowDown--;
            if (left <= right) {
                int cur = rowDown;
                while (cur >= rowUp) {
                    result.add(matrix[cur][left]);
                    cur--;
                }
            }
            left++;
        }
        return result;
    }
}
