package com.algorithm;

public class LC0036 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] cell = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '1';
                if (row[i][curNum] || column[j][curNum] || cell[3 * (i / 3) + j / 3][curNum]) {
                    return false;
                }
                row[i][curNum] = true;
                column[j][curNum] = true;
                cell[3 * (i / 3) + j / 3][curNum] = true;
            }
        }
        return true;
    }
}
