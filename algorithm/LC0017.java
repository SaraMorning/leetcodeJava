package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0017 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    void dfs(String digit, String prefix,List<String> result){
        if(digit==null || digit.isEmpty()) {
            result.add(prefix);
            return;
        }

        String cur = digit.substring(0,1);
        String chars = phone.get(cur);
        for(int i=0;i<chars.length();++i) {
            dfs(digit.substring(1), prefix+chars.charAt(i), result);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        dfs(digits, "",result);
        return result;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        dfs2(digits, "", result);
        return result;
    }

    void dfs2(String digit, String prefix, List<String> result) {
        if (digit == null || digit.isEmpty()) {
            result.add(prefix);
            return;
        }
        String curDigit = digit.substring(0, 1);
        String chars = phone.get(curDigit);
        for (int i = 0; i < chars.length(); ++i) {
            dfs2(digit.substring(1), prefix + chars.charAt(i), result);
        }
    }
}
