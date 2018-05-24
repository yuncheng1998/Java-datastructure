package com.lab6;

import java.util.*;

class Table {

    private HashMap<String, Integer> map = new HashMap<>();

    Table(Map<String, Integer> map) {
        this.map = (HashMap<String, Integer>) map;
    }
    Table() {

    }

    HashMap<String, Integer> getTable() {
        return this.map;
    }

    //查找读取后的字符串中的单词，进行计数
    void countWords(String str, HashMap<String, Integer> map) {
        if (str == null || str.equals(" ")) {
            System.out.print("读取文件为空");
            return;
        }
        String[] words = str.split("[^a-zA-Z0-9_]+");
        for (String word : words) {
            word = word.toLowerCase();
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
    }

    //根据用户的需求查找
    void searchWord(String word, Map map){
        if(map.get(word) != null){
            System.out.println(word + "出现的频率: " + map.get(word));
        }else{
            System.out.println("没有找到" + word);
        }
    }
    

    void doStatistics(Table table, FileOpt fileOpt, String path, int number) {

        List<Map.Entry<String, Integer>> List_Data = new ArrayList<>(table.getTable().entrySet());
        List_Data.sort((o1, o2) -> {
            if (o2.getValue() != null && o1.getValue() != null && o2.getValue().compareTo(o1.getValue()) > 0) {
                return 1;
            } else {
                return -1;
            }
        });
        if (number > List_Data.size()) {
            System.out.println("单词数量小于" + number);
        } else {
            try {
                for (int i = 0; i < List_Data.size(); i++) {
                    String word = List_Data.get(i).getKey();
                    String num = List_Data.get(i).getValue().toString();
                    if (i < 10) {
                        System.out.println(word + ":" + num + " ");
                    }
                    fileOpt.write(word + ":" + num + "\n", path);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("排序时传入集合为空,程序结束");
            }
        }

    }


}
