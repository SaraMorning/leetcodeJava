package com.Exam;

import java.util.Arrays;

public class Exam042403 {
    int row;
    int column;
    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int noise(int n, int m, int[][] values) {
        this.row = n;
        this.column = m;
        int[][] noise = new int[n][m];
        for (int[] value : values) {
            int curRow = value[0];
            int curColumn = value[1];
            int curNoise = value[2];
            dfs(noise, curRow, curColumn, curNoise);
        }
        return Arrays.stream(noise).flatMapToInt(Arrays::stream).sum();
    }

    private void dfs(int[][] noise, int curRow, int curColumn, int newNoise) {
        if (curRow < 0 || curRow >= row || curColumn < 0 || curColumn >= column
            || noise[curRow][curColumn] >= newNoise) {
            return;
        }
        noise[curRow][curColumn] = newNoise;
        for(int[] curDir : directions){
            dfs(noise, curRow + curDir[0], curColumn + curDir[1], newNoise - 1);
        }
    }

    public static void main(String[] args) {
        Exam042403 test = new Exam042403();
        int n = 5;
        int m = 6;
        int[][] arr = {{3, 4, 3}, {1, 1, 4}};
        int result = test.noise(n, m, arr);
        System.out.println(result);
        int i = 0;
    }
}
