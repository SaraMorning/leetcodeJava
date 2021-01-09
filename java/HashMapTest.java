package com.java;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapTest {
    public static void main(String[] args) {

        /*
         * 常用方法：
         * compute、computeIfAbsent、computeIfPresent、merge
         * containsKey、containsValue、get、
         * put、putAll、clear、remove、isEmpty、size
         * entrySet(可进行流操作)、keySet、Values(返回map中所有的value组成的集合)，三者都是map的view，remove等操作会影响原集合
         */

        Map<String, String> map = new java.util.HashMap<>();
        /* 清空map中的数据 */
        map.clear();
        map.put("key1", "value");
        map.put("key2", null);
        map.put(null, null);
        System.out.println(map);

        List<String> list = map.entrySet().stream().filter(entry -> "key1".equals(entry.getValue()))
            .map(Map.Entry::getValue).collect(Collectors.toList());
        /*
        * compute
        * 1、key有值，value有值，map中的value更新为新值，返回新value
        * 2、key为null或者有值，value为null，该key对应的map映射为新的value，返回新value
        * 3、key不存在，map添加该对key、value，返回新value
        * 4、如果新value为null，则删除对应的key、value，
        * If the remapping function returns null, the mapping is removed (or remains absent if initially absent).
        */
        map.compute("key1", (key, value) -> value + " new compute value1");
        map.compute("key2", (key, value) -> value + " new compute value2");
        map.compute(null, (key, value) -> value + " new compute null");
        map.compute("key3", (key, value) -> value + " new compute value3");
        map.compute("new key", (key, value) -> {
            if (value == null) {
                value = "null value " + 0;
            } else {
                value = value + 1;
            }
            return value;
        });
        System.out.println(map);
        map.compute("key2", (key, value) -> null);
        System.out.println(map);
        /*
         * computeIfAbsent
         * 1、key有值，value有值，map中的值不做改变，返回原value
         * 2、key为null或者有值，value为null，该key对应的map映射为新的value，返回新value
         * 3、key不存在，map添加该对key、value，返回新value
         * 4、新value为null，对原map不起作用，
         * If the specified key is not already associated with a value (or is mapped to null),
         * attempts to compute its value using the given mapping function and enters it into this map unless null.
         * If the mapping function returns null, no mapping is recorded.
         */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, null);
        System.out.println(map);
        map.computeIfAbsent("key1", key -> " computeIfAbsent new value1");
        map.computeIfAbsent("key2", key -> " computeIfAbsent new value2");
        map.computeIfAbsent(null, key -> " computeIfAbsent new value null");
        map.computeIfAbsent("key3", key -> " computeIfAbsent new value3");
        System.out.println(map);
        map.computeIfAbsent("key2", key -> null);
        map.computeIfAbsent("key4", key -> null);
        System.out.println(map);

        /*
         * computeIfPresent
         * 1、key有值或为null，value有有效值，map中的value更新为新value，如果新value为null，则删除对应key、value
         * 2、key为null或者有值，value为null，map不更新，返回null
         * 3、key不存在，map不更新，返回null
         * If the value for the specified key is present and non-null,
         * attempts to compute a new mapping given the key and its current mapped value.
         * If the remapping function returns null, the mapping is removed
         */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, "");
        System.out.println(map);
        map.computeIfPresent("key1", (key, value) -> value + " computeIfPresent new value1");
        map.computeIfPresent("key2", (key, value) -> value + " computeIfPresent new value2");
        map.computeIfPresent(null, (key, value) -> value + " computeIfPresent new value null"); //如果原value无效，则不更新
        map.computeIfPresent("key3", (key, value) -> value + " computeIfPresent new value3");
        System.out.println(map);
        map.computeIfPresent("key2", (key, value) -> null);
        System.out.println(map);

        /*
        * merge
        * newValue不能为空
        * 如果原value为null，直接更新为新value，不用remappingFunction返回的值
        * remappingFunction返回null，删除map中对应的key、value
        * If the specified key is not already associated with a value or is associated with null,
        * associates it with the given non-null value.
        * Otherwise, replaces the associated value with the results of the given remapping function,
        * or removes if the result is null.
        */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, "");
        System.out.println(map);
        map.merge("key1", " merge new value1", (oldValue, newValue) -> oldValue + newValue);
        map.merge("key2", " merge new value2", (oldValue, newValue) -> "return merge new value2");
        map.merge(null, " merge new value null", (oldValue, newValue) -> oldValue + newValue);
        map.merge("key3", " merge new value3", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
        //map.merge("key2", null, (oldValue, newValue) -> newValue); //java.lang.NullPointerException
        map.merge("key2", "new value2", (oldValue, newValue) -> null);
        System.out.println(map);

        System.out.println();
        map.clear();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");

        map.put("key4", "value2");
        map.put("key5", "value2");
        map.put("key6", "value2");
        Set<String> keySet = map.keySet();
        Collection<String> values = map.values();
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);

        /* remove value时，找到map中第一个value为对应值得key、value，并将其删除 */
        System.out.println();
        values.remove("value1");
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);

        System.out.println();
        keySet.remove("key4");
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);
    }
}
