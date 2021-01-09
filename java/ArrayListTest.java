package com.java;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {

        /*
         * 常用方法：
         * add、addAll、clone(浅拷贝)、copyOf
         * clear、ensureCapacity(ArrayList指定list的最小容量)、isEmpty
         * forEach、get、indexOf(无效返回-1)、lastIndexOf(无效返回-1)、contains、containsAll
         * remove、removeAll、removeIf
         * iterator
         */
        ArrayList<String> list = new ArrayList();
        list.add("String1");
        list.add(0, "String2");
        System.out.println(list);
        //list.ensureCapacity(26);
        list.forEach(str -> System.out.println(str.length()));
        list.removeIf(value -> "String2".equals(value));
        System.out.println(list);

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        int m = stack.search(1);

        int i = 0;
    }
}
