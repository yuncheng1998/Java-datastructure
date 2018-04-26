package com.lab4;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.lab4.Tree.handle2Tree;

public class ForthLab {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String judge = "Y";
        String isFile;
        String line;
        ArrayList<String> strings;
        System.out.println("文件输入?(Y/N)");
        isFile = scanner.next();
        switch (isFile) {
            case "Y":
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("/home/yuncheng/IdeaProjects/DataStr/src/com/lab4/file.txt"));
                lineNumberReader.setLineNumber(0);

                while ((line = lineNumberReader.readLine()) != null) {
                    System.out.println("英文原句: " + line);
                    strings = new ArrayList<>(Arrays.asList(line.split(" ")));  //单词集合
                    handle2Tree(strings);
                }

                break;
            case "N":
                while (judge.equals("Y")) {
                    scanner = new Scanner(System.in);    //分隔输入句子的单词

                    System.out.println("输入英文句子");
                    strings = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

                    handle2Tree(strings);
                    System.out.println("继续输入?(Y/N)");
                    judge = scanner.next();
                }
                break;
            default:
                System.out.println("参数错误");
                break;
        }
    }

}
