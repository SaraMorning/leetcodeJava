package com.algorithm;

public class LC0695 {
    int row;
    int column;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        this.row = grid.length;
        this.column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int max = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                int curSize = calculate(grid, visited, i, j);
                if (curSize > max) {
                    max = curSize;
                }
            }
        }
        return max;
    }

    private int calculate(int[][] grid, boolean[][] visited, int curRow, int curColumn) {
        if (curRow < 0 || curRow >= row || curColumn < 0 || curColumn >= column || grid[curRow][curColumn] == 0
        || visited[curRow][curColumn] == true) {
            return 0;
        }
        visited[curRow][curColumn] = true;
        int curSize = 1;
        for (int[] direction : directions) {
            curSize += calculate(grid, visited, curRow + direction[0], curColumn + direction[1]);
        }
        return curSize;
    }

    public static void main(String[] args) {
        LC0695 test = new LC0695();
        int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        test.maxAreaOfIsland(arr);
    }
}
