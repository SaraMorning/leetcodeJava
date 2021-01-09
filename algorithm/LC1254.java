package com.algorithm;

public class LC1254 {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (i * j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    fill(grid, i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                result += fill(grid, i, j) > 0 ? 1 : 0;
            }
        }
        return result;
    }

    private int fill(int[][] grid, int curRow, int curColumn) {
        if (curRow < 0 || curRow >= grid.length || curColumn < 0 || curColumn >= grid[0].length || grid[curRow][curColumn] == 1) {
            return 0;
        }
        grid[curRow][curColumn] = 1;
        int sum = 1;
        for (int[] direction : directions) {
            sum += fill(grid, curRow + direction[0], curColumn + direction[1]);
        }
        return sum;
    }
}
