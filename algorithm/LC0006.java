package com.algorithm;

public class LC0006 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        int strLen = s.length();
        String[] arr = new String[numRows];
        boolean goingDown = false;
        int curRow = 0;
        for (int i = 0; i < strLen; ++i) {
            if (arr[curRow] == null) {
                arr[curRow] = "" + s.charAt(i);
            } else {
                arr[curRow] += s.charAt(i);
            }
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder("");
        for (String curStr : arr) {
            sb.append(curStr);
        }
        return sb.toString();
    }


    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        boolean goingDown = false;
        String[] rows = new String[Math.min(len, numRows)];
        int curRow = 0;
        for (int i = 0; i < len; ++i) {
            if (rows[curRow] == null) {
                rows[curRow] = "" + s.charAt(i);
            } else {
                rows[curRow] += s.charAt(i);
            }
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        String ret = "";
        for (String row : rows) {
            ret += row;
        }
        return ret;
    }
}
