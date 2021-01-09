package com.algorithm;

import java.util.*;

public class LC0022 {
    int pairsCount;
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.pairsCount = n;
        dfs(0,0,"");
        return  result;
    }
    private void dfs(int left, int right, String curBrackets) {
        if (left == right && left == pairsCount) {
            result.add(curBrackets);
            return;
        }

        if(right<left) dfs(left, right + 1, curBrackets + ")");
        if(left<pairsCount) dfs(left+1,right,curBrackets+"(");
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs2(0, 0, "", n, result);
        return result;
    }

    private void dfs2(int left, int right, String curBrackets, int n, List<String> result) {
        if (left == right && left == n) {
            result.add(curBrackets);
            return;
        }
        if (left < n) {
            dfs2(left + 1, right, curBrackets+"(", n, result);
        }
        if (right < left) {
            dfs2(left, right+1, curBrackets+")", n, result);
        }
    }
}
