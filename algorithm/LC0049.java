package com.algorithm;
import java.util.*;
import java.util.stream.Collectors;

public class LC0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String curStr : strs) {
            char[] characters = curStr.toCharArray();
            Arrays.sort(characters);
            String strVal = String.valueOf(characters);
            if (map.containsKey(strVal)) {
                List<String> list = map.get(strVal);
                list.add(curStr);
            } else {
                map.put(strVal, new ArrayList<>(Arrays.asList(curStr)));
            }
        }
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
