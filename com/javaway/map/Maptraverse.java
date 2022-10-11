package com.javaway.map;

import java.util.*;

public class Maptraverse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        map.put("liuweihao", 100);
        map.put("liu", 10);
        map.put("liuweihao", 200);
        map.put("weihao", 100);
        map.put("hao", 100);

        //通过键的遍历
        Set<String> KeySet = map.keySet();
        for (String Key : KeySet) {
            System.out.println(Key + "+" + map.get(Key));
        }
        Iterator<String> iterator = KeySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "+" + map.get(key));
        }
        //取出所有的values
        Collection<Integer> values = map.values();
        for (Integer val : values) {
            System.out.println(val);
        }
        Iterator<Integer> iter = values.iterator();
        while (iter.hasNext()) {
            Integer Val = iter.next();
            System.out.println(Val);
        }
        //键值对
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Object entry : entries) {
            System.out.println(entry);
        }

        Iterator<Map.Entry<String, Integer>> ITer = entries.iterator();
        while (ITer.hasNext()) {
            Object ent = ITer.next();
            System.out.println(ent);
        }
    }
}
