package com.algorithm;
import java.util.*;
public class LC0119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList();
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        generateRow(rowIndex+1, list);
        return list.get(rowIndex);
    }
    public void generateRow (int numRows, List<List<Integer>> list) {
        List<Integer> rowList = new ArrayList();
        rowList.add(1);
        if (numRows == 1) {
            list.add(rowList);
            return;
        }
        generateRow(numRows - 1, list);
        List<Integer> lastRow = list.get(numRows - 2);
        for(int j = 1; j < numRows - 1; ++j) {
            rowList.add(lastRow.get(j-1) + lastRow.get(j));
        }
        rowList.add(1);
        list.add(rowList);
    }
}
