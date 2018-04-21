package com.lab1;

import java.util.Scanner;

public class FirstLab {
    public static void main(String[] args)  {

        String judge;
        List list;
        int local;
        Scanner scanner = new Scanner(System.in);
        try{
            do{
                System.out.println("输入数字，#结尾结束");
                FirstLab lab = new FirstLab();
                list = lab.createList();
                System.out.println("请输入相邻的位数");
                local = scanner.nextInt();
                lab.Adjmax(list, local);
                System.out.println("继续输入?(Y/N)");
                judge =  scanner.next();
            }while(judge.equals("Y") );
        }catch(Exception e){
            System.out.println("输入参数有误");
        }

    }

    private List createList(){
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
    private void Adjmax(List L, int k){
        List.Node p1,p2;
        int k1;
        int sum=0, max=0;
        int location=0;//记录最大值位置
        int val=0;//记录最大的data
        p1 = L.getHead();
        if(p1 == null || (L.getLength())-1 < k ){
            System.out.println("相邻位数超范围");
            return ;
        }
        while(p1 != null){
            k1 = k;
            p2 = p1;
            while((k1--!=0) && (p2!=null)){
                sum += p2.getData();
                p2 = p2.next;
            }
            if(sum > max){
                location = p1.getId();
                val = p1.getData();
                max = sum;
            }
            p1 = p1.next;
            sum = 0;
        }
        System.out.println("第"+location + "个数，" +"值为"+ val + "，最大值:"+ max);
    }

}