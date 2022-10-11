package com.javaway.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//判断word字符串，只删除一个元素，能否使得串内所有元素等频率
public class hashmao {
    public static void main(String[] args) {
        String word = "aabbc";
        System.out.println(equalFrequency(word));
    }

    public static boolean equalFrequency(String word) {
        char[] charArray = word.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();//储存每个键出现的次数
        for (char c : charArray) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        Set<Character> keySet = hashMap.keySet();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();//储存每个频率出现的次数
        for (Character key : keySet) {
            treeMap.put(hashMap.get(key), treeMap.getOrDefault(hashMap.get(key), 0) + 1);//若存在键则读取该键的值
            //否则为0
        }
        if (treeMap.size() > 2) {
            return false;
        } else if (treeMap.size() == 1) {
            return hashMap.size() == 1 || treeMap.containsKey(1);
        } else if (treeMap.containsKey(1) && treeMap.get(1) == 1) {
            return true;
        } else if (treeMap.lastKey() - treeMap.firstKey() == 1) {
            return treeMap.lastEntry().getValue() == 1;
        }
        return false;
    }
}

