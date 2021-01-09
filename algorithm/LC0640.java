package com.algorithm;

public class LC0640 {
    public String solveEquation(String equation) {
        String[] equations = equation.split("=");
        int[] left = evaluateExpression(equations[0]);
        int[] right = evaluateExpression(equations[1]);
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        }
        if (left[0] == right[0] && left[1] != right[1]) {
            return "No solution";
        }
        return "x=" + ((right[1] - left[1]) / (left[0] - right[0]));
    }

    public int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[+-])");
        int[] res = new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                res[0] += 1;
            } else if (token.equals("-x")) {
                res[0] -= 1;
            } else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }
}
