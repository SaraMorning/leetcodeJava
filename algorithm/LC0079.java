package com.algorithm;

public class LC0079 {
    private int rows;
    private int columns;
    private char[][] board;
    private String word;
    private boolean[][] marks;
    private int[][] direction = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board[0].length == 0) {
            return false;
        }
        this.board = board;
        rows = board.length;
        columns = board[0].length;
        this.word = word;
        marks = new boolean[rows][columns];
        for (int rowIndex = 0; rowIndex < rows; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < columns; ++columnIndex) {
                if (search(rowIndex, columnIndex, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(int row, int column, int start) {
        if (start == word.length() - 1) {
            return word.charAt(start) == board[row][column];
        }
        if (word.charAt(start) != board[row][column]) {
            return false;
        }
        marks[row][column] = true;
        for (int i = 0; i < 4; ++i) {
            int newRow = row + direction[i][0];
            int newColumn = column + direction[i][1];
            if (inBoard(newRow, newColumn) && !marks[newRow][newColumn]) {
                if (search(newRow, newColumn, start + 1)) {
                    return true;
                }
            }
        }
        marks[row][column] = false;
        return false;
    }

    private boolean inBoard(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return false;
        }
        return true;
    }
}
