package com.javaway.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class KestMaxnum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3};
        int k = 2;

    }

    public static int way(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//降序(key的值)
            }
        };
        for (Integer n : nums) {
            if (map.containsKey(n)) {
                Integer count = map.get(n);
                map.put(n, count + 1);
            } else map.put(n, 1);
        }
        return -1;
    }

}
