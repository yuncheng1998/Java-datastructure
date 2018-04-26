package com.lab2;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class SecondLab {

    public static void main(String[] args) throws IOException {
        String inExp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("是否从文件读入(Y/N)?");
        String fileRead = scanner.nextLine();

        if (fileRead.equals("Y")) {
            LineNumberReader number = new LineNumberReader(new FileReader("/home/yuncheng/IdeaProjects/DataStr/src/com/lab2/exp.txt"));
                String line;
                number.setLineNumber(0);
                while ((line = number.readLine()) != null) {
                    System.out.println("中缀表达式：" + line);
                    PostExp postExp = new PostExp(line);
                    System.out.println("后缀表达式：" + postExp.getPostExp());
                    System.out.println("表达式的值：" + postExp.getValue());
                }


        } else {
            System.out.println("输入表达式或quit退出");
            inExp = scanner.nextLine();
            while (!inExp.equals("quit")) {
                PostExp postExp = new PostExp(inExp);
                System.out.println("后缀表达式：" + postExp.getPostExp());
                System.out.println("表达式的值：" + postExp.getValue());
                System.out.println("输入表达式或quit退出");
                inExp = scanner.nextLine();
            }
        }
    }










}

