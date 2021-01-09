package com.algorithm;

public class LC0463 {
    public int islandPerimeter(int[][] grid) {
        int neighbours = 0;
        int islandCount = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbours++;
                }
            }
        }
        return islandCount * 4 - neighbours *2;
    }
}
