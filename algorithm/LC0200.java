package com.algorithm;

public class LC0200 {
    int row;
    int column;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        this.row = grid.length;
        this.column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int size = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                visitCurNode(grid, visited, i, j);
                size++;
            }
        }
        return size;
    }

    private void visitCurNode(char[][] grid, boolean[][] visited, int curRow, int curColumn) {
        if (curRow < 0 || curRow >= row || curColumn < 0 || curColumn >= column || grid[curRow][curColumn] == '0'
                || visited[curRow][curColumn] == true) {
            return;
        }
        visited[curRow][curColumn] = true;
        for (int[] direction : directions) {
            visitCurNode(grid, visited, curRow + direction[0], curColumn + direction[1]);
        };
    }
}
