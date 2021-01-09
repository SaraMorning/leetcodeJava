package com.algorithm;
import java.util.*;
public class LC0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        if (numRows <= 0) {
            return list;
        }
        generateRow(numRows, list);
        return list;
    }

    public void generateRow(int numRows, List<List<Integer>> list) {
        List<Integer> rowList = new ArrayList();
        rowList.add(1);
        if (numRows == 1) {
            list.add(rowList);
            return;
        }
        generateRow(numRows - 1, list);
        List<Integer> lastRow = list.get(numRows - 2);
        for (int j = 1; j < numRows - 1; ++j) {
            rowList.add(lastRow.get(j - 1) + lastRow.get(j));
        }
        rowList.add(1);
        list.add(rowList);
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            // The last row element is always 1.
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
