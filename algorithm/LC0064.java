package com.algorithm;

public class LC0064 {
    int[][] grid;
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        this.grid = grid;
        for (int curX = 0; curX < row; ++curX) {
            for (int curY = 0; curY < column; ++curY) {
                setMinSum(curX, curY);
            }
        }
        return grid[row-1][column-1];
    }
    private void setMinSum(int curX, int curY) {
        if (curX == 0 && curY == 0) {
            return;
        }
        if (curX == 0) {
            grid[curX][curY] += grid[curX][curY - 1];
            return;
        }

        if (curY == 0) {
            grid[curX][curY] += grid[curX - 1][curY];
            return;
        }
        grid[curX][curY] += Math.min(grid[curX - 1][curY], grid[curX][curY - 1]);
    }
}
