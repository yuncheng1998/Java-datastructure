package com.lab6;

import java.util.Map;

class MapOpt {
    static Map<String, Integer> mergeMap(Map<String, Integer>map, Map<String,Integer> map2) {
        for (String key2 : map2.keySet()) {
            Integer value2 = map2.get(key2);
            Integer value;
            if (map.containsKey(key2)) {
                value = map.get(key2) + value2;
            } else {
                value = value2;
            }
            map.replace(key2, value);
        }
        return map;
    }
}
