package com.lab6;

import java.io.FileWriter;
import java.util.Scanner;

public class SixthLab {

    public static void main(String[] args) {

        String LOG_PATH = "/home/yuncheng/IdeaProjects/DataStr/src/com/lab6/log.txt";
        String ARTICLE_PATH = "/home/yuncheng/IdeaProjects/DataStr/src/com/lab6/Bible.txt";
        int number = 10;

        FileOpt fileOpt = new FileOpt();
        Table table = new Table();

        /* 读取上次保存的数据 */
        String logString = fileOpt.read(LOG_PATH);
        String[] logs = logString.split(" ");

        System.out.println("上次统计的结果:");
        for (String string : logs) {
            System.out.println(string);
        }

        fileOpt.clear(LOG_PATH);// 清空原文件

        table.countWords(fileOpt.read(ARTICLE_PATH), table.getTable());// 将所有的数据进行统计

        System.out.println("单词出现频率最高统计");
        table.doStatistics(table, fileOpt, LOG_PATH, number);// 排序取前十个频率最高的单词

        Scanner in = new Scanner(System.in);

        boolean flag = true;

        System.out.println();
        System.out.println("请输入要执行的操作， 0:初始化 1:查找 2:退出 3:追加统计 4:追加文本");

        while (flag && in.hasNext()) {
            int operation = in.nextInt();
            switch (operation) {
                case 0:
                    fileOpt.clear(LOG_PATH);
                    System.out.println("已完成初始化log");
                    break;
                case 1:
                    System.out.println("请输入要查找的单词");
                    table.searchWord(new Scanner(System.in).nextLine(), table.getTable());
                    break;
                case 2:
                    System.out.println("程序退出");
                    flag = false;
                    break;
                case 3:
                    fileOpt.clear(LOG_PATH);
                    System.out.println("是否要在控制台输入追加信息?(Y/N)");
                    if (new Scanner(System.in).nextLine().equals("Y")) {
                        String string = new Scanner(System.in).nextLine();
                        try {
                            FileWriter fw=new FileWriter(ARTICLE_PATH,true);
                            fw.write(" " + string);
                            fw.close();
                        }
                        catch(Exception e) {
                            System.out.println("写入错误："+e.toString());
                        }
                    }
                    table = new Table();
                    table.countWords(fileOpt.read(ARTICLE_PATH), table.getTable());// 将所有的数据进行统计
                    table.doStatistics(table, fileOpt, LOG_PATH, number);// 排序取前十个频率最高的单词

                    System.out.println("重新统计完成");
                    break;
                case 4:
                    System.out.println("输入追加统计的文件路径");
                    Scanner scanner = new Scanner(System.in);
                    String FileName = scanner.nextLine();
                    Table table2 = new Table();
                    table2.countWords(fileOpt.read(FileName), table2.getTable());
                    Table table3 = new Table(MapOpt.mergeMap(table.getTable(), table2.getTable()));
                    table3.doStatistics(table3,fileOpt,LOG_PATH,number);
                    break;
                default:
                    System.out.println("输入参数有问题");
            }
        }
    }
}
