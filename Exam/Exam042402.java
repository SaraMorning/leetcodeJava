package com.Exam;

public class Exam042402 {
    private int layerSum(String input) {
        int curLayer = 1;
        int strLen  = input.length();
        int sum = 0;
        for (int i = 0; i < strLen; ++i) {
            if (input.charAt(i) == ',') {
                continue;
            }
            if (input.charAt(i) == '(') {
                curLayer++;
                continue;
            }
            if (input.charAt(i) == ')') {
                curLayer--;
                continue;
            }
            int start = i;
            int end = i;
            while (end < strLen && input.charAt(end) >= '0' && input.charAt(end) <= '9') {
                ++end;
            }
            int curNum = Integer.valueOf(input.substring(start, end));
            sum += curNum * curLayer;
            i = end - 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Exam042402 test = new Exam042402();
        String str = new String("(12,3(4(6,7)10)5(2,7)1)3");
        int result = test.layerSum(str);
        System.out.println(result);
    }
}
