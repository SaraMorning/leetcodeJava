package com.algorithm;

public class LC0678 {
    public boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int start, int leftCount) {
        if (start == s.length()) {
            return leftCount == 0;
        }
        char curChar = s.charAt(start);
        switch (curChar) {
            case '(':
                return dfs(s, start + 1, leftCount + 1);
            case ')':
                if (leftCount > 0) {
                    return dfs(s, start + 1, leftCount - 1);
                } else {
                    return false;
                }
            case '*':
                return dfs(s, start + 1, leftCount + 1)
                        || leftCount > 0 && dfs(s, start + 1, leftCount - 1)
                        || dfs(s, start + 1, leftCount);
        }
        return false;
    }

    public boolean checkValidString2(String s) {
        char[] arr = s.toCharArray();
        int MaxRBrackets = 0;
        int MinRBrackets = 0;
        for (char curChar : arr) {
            switch (curChar) {
                case '(':
                    MaxRBrackets++;
                    MinRBrackets++;
                    break;
                case ')':
                    MaxRBrackets--;
                    MinRBrackets = Math.max(MinRBrackets - 1, 0);
                    if (MaxRBrackets < 0) {
                        return false;
                    }
                    break;
                case '*':
                    MaxRBrackets++;
                    MinRBrackets = Math.max(MinRBrackets - 1, 0);
                    break;
                default:
                    return false;
            }
        }
        return MinRBrackets == 0;
    }
}
