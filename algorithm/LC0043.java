package com.algorithm;

import java.util.Arrays;

public class LC0043 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] mul = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; --i) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                int bitMul = n1 * n2 + mul[i + j + 1];
                mul[i + j + 1] = bitMul % 10;
                mul[i + j] += bitMul / 10;
            }
        }
        StringBuilder result = new StringBuilder("");
        boolean isStartWithZero = true;
        for (int bit : mul) {
            if (bit == 0 && isStartWithZero) {
                continue;
            }
            result.append((char) (bit + '0'));
            isStartWithZero = false;
        }
        return result.toString();
    }

    public String multiply2(String num1, String num2) {
        int carr = 0;
        int[] temResult = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            int firstNum = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; --j) {
                int secondNum = num2.charAt(j) - '0';
                int multi = firstNum * secondNum + temResult[i+j+1];
                temResult[i+j] += multi / 10;
                temResult[i+j+1] = multi % 10;
            }
        }
        StringBuilder result = new StringBuilder("");
        boolean isStartWithZero = true;
        for (int bit : temResult) {
            if (bit == 0 && isStartWithZero) {
                continue;
            }
            result.append(bit);
            isStartWithZero = false;
        }
        if (isStartWithZero) {
            return "0";
        }
        return result.toString();
    }
}
