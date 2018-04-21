package com.lab3;

import java.util.Scanner;

public class ThirdLab {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        char c;
        String judge = "Y";
        while(judge.equals("Y")){
            System.out.println("输入字符");
            c = scanner.next().charAt(0);
            switch (c) {
                case '0': {
                    if (queue.isEmpty()) {
                        System.out.println(queue.deQueue());
                        break;
                    } else {
                        System.out.println("Queue is Empty");
                        break;
                    }
                }
                case '@' : {
                    while (queue.isEmpty()) {
                        System.out.println(queue.deQueue());
                    }
                    System.out.println("是否继续?(Y/N)");
                    judge = scanner.next();
                }
                default: {
                    queue.enQueue(c);
                }
            }
        }
        if (judge.equals("N")) {
            System.out.println("退出");
        } else {
            System.out.println("输入错误,退出程序");
        }
    }
}
