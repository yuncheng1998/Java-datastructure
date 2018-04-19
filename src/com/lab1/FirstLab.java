package com.lab1;

import java.util.Scanner;

public class FirstLab {
    public static void main(String[] args)  {

        String go;
        List list;
        int local;
        Scanner br = new Scanner(System.in);
        try{
            do{
                System.out.println("输入数字，按下‘#’结束");
                FirstLab lab = new FirstLab();
                list = lab.CreatList();
                System.out.println("请输入相邻的位数");
                local = br.nextInt();
                lab.Adjmax(list, local);
                System.out.println("继续请输入：Yes");
                go =  br.next();
            }while(go.equals("Yes") );
        }catch(Exception e){
            System.out.println("输入参数有误");
        }

    }

    private List CreatList(){
        List list = new List();
        String k;
        int number;
        Scanner cin = new Scanner(System.in);

        /*读取输入的链表*/
        while(cin.hasNext()){
            k = cin.next();
            if(k.equals("#")){
                break;
            }else{
                number = Integer.valueOf(k);
            }
            list.insertNode(number);
        }
        list.printList(list.getHead());
        return list;
    }

    /*求相邻最大和*/
    private void Adjmax(List L, int k){
        Node p1,p2;
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
        System.out.println("  序号: "+location +"  data值: "+ val + "  最大值: "+ max);
    }

}