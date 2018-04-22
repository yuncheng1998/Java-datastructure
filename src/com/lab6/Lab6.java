package com.lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lab6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/home/yuncheng/IdeaProjects/DataStr/src/com/lab6/article.txt"));
        String line;
        ArrayList<String> arrayList = null;
        while ((line = br.readLine()) != null) {
            //TODO: 匹配
            arrayList = new ArrayList<>(Arrays.asList(line.split(" ")));
        }

        HashMap hashMap;
        Table table = new Table(arrayList);

        hashMap = table.doStatistics();

        System.out.println(hashMap);

    }
}
