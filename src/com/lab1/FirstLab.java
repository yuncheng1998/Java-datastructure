package com.lab1;

import java.util.Scanner;

public class FirstLab {
    public static void main(String[] args)  {

        String judge;
        List list;
        int location;
        Scanner scanner = new Scanner(System.in);
        try{
            do{
                System.out.println("输入数字，#结尾结束");
                list = List.createList();
                System.out.println("请输入相邻的位数");
                location = scanner.nextInt();
                String str = List.Adjmax(list, location);
                System.out.println(str);
                System.out.println("继续输入?(Y/N)");
                judge =  scanner.next();
            }while(judge.equals("Y") );
        }catch(Exception e){
            System.out.println("输入参数有误");
        }

    }
}