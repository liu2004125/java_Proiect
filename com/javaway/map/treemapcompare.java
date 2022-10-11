package com.javaway.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class treemapcompare {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);//降序
            }
        };
        Map<String, Integer> map = new TreeMap<>(comparator);
        map.put("ja", 2);
        map.put("bo", 1);
        map.put("bs", 4);
        map.put("sa", 3);
        // 按key降序

        for (String s : map.keySet()) {
            System.out.println(s + map.get(s));
        }
        //按value排序
        Comparator<Map.Entry<String, Integer>> valuecompare = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();//升序排行
            }
        };

        for (String s : map.keySet()) {
            System.out.println(s + map.get(s));
        }
    }
}
