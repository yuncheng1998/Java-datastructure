package com.lab6;

import java.util.ArrayList;
import java.util.HashMap;

class Table {
    private HashMap<String, Integer> hashMap;

    private ArrayList<String> strings;

    Table(ArrayList<String> strings) {
        this.strings = strings;
        this.hashMap = new HashMap<>();
    }

    HashMap doStatistics () {

        for (String str : strings) {  //key -> 单词, value -> 出现的次数
            if (hashMap == null ||hashMap.get(str) == null) {         //get(key) 没有这个单词->加入，num=1
                assert hashMap != null;
                hashMap.put(str, 1);
            } else {                                //有单词，把value取出加1
                Integer num = hashMap.get(str);
                num = num + 1;
                hashMap.put(str, num);
            }
        }
        return hashMap;
    }

}
