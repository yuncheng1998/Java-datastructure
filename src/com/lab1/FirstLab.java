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
                list = FirstLab.createList();
                System.out.println("请输入相邻的位数");
                location = scanner.nextInt();
                FirstLab.Adjmax(list, location);
                System.out.println("继续输入?(Y/N)");
                judge =  scanner.next();
            }while(judge.equals("Y") );
        }catch(Exception e){
            System.out.println("输入参数有误");
        }

    }

    private static List createList(){
        List list = new List();
        String str;
        int number;
        Scanner scanner = new Scanner(System.in);

        /*读取输入的链表*/
        while(scanner.hasNext()){
            str = scanner.next();
            if(str.equals("#")){
                break;
            }else{
                number = Integer.valueOf(str);
            }
            list.insertNode(number);
        }
        list.printList(list.getHead());
        return list;
    }

    /*求相邻最大和*/
    private static void Adjmax(List L, int k){
        List.Node p, q;
        int k1;
        int sum = 0, max = 0;
        int location = 0;//记录最大值位置
        int value = 0;//记录最大的data
        p = L.getHead();
        if(p == null || (L.getLength()) - 1 < k ){
            System.out.println("相邻位数超范围");
            return ;
        }
        while(p != null){
            k1 = k;
            q = p;
            while((k1-- != 0) && (q != null)){
                sum += q.getData();
                q = q.next;
            }
            if(sum > max){
                location = p.getId();
                value = p.getData();
                max = sum;
            }
            p = p.next;
            sum = 0;
        }
        System.out.println("第"+location + "个数，" +"值为"+ value + "，最大值:"+ max);
    }

}