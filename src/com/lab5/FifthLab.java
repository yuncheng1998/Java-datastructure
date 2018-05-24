package com.lab5;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FifthLab {
    public static void main(String[] args) throws IOException {
        String FileName = "/home/yuncheng/IdeaProjects/DataStr/src/com/lab5/CycleGraph";
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<String> relationship = new ArrayList<>();
        Graph graph = new Graph();
        String judge;
        System.out.println("是否从文件输入?(Y/N)");
        Scanner scanner = new Scanner(System.in);
        judge = scanner.next();
        if (judge.equals("Y")) {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(FileName));
            String line;
            lineNumberReader.setLineNumber(0);
            while ((line = lineNumberReader.readLine()) != null) {
                if (lineNumberReader.getLineNumber() == 1) {
                    String[] nodes = line.split(" ");
                    for (String node : nodes) {
                        data.add(Integer.parseInt(node));
                    }
                } else {
                    relationship.add(line);
                }
            }
            if (data.isEmpty()) {
                System.out.println("没有顶点");
            } else {
                graph.topSort(graph.createList(data, relationship));
            }

        } else {
            System.out.println("输入顶点");
            Scanner scanner1 = new Scanner(System.in);
            String str;
            if ((str = scanner1.nextLine()) != null && str.length() > 0) {
                String[] n = str.split(" ");
                for (String node : n) {
                    data.add(Integer.parseInt(node));

                }
                System.out.println("输入边，例如1,2，输入end结束");
                String line;
                while (!(line = scanner1.nextLine()).equals("end")) {
                    relationship.add(line);
                }
                graph.topSort(graph.createList(data, relationship));
            } else {                System.out.println("空图");

            }


        }
    }
}
