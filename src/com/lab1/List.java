package com.lab1;

import java.util.Scanner;

class List {

    private int id = 1;

    private Node head,tail;//头结点和尾节点

    private List(){
        head = null;
    }

    class Node {

        private int id;
        private int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

        void setId(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }

        int getData() {
            return data;
        }
    }


    Node getHead() {
        return this.head;
    }


    int getLength(){
        int len = 0;
        Node p = head;
        while( p!=null ){
            len++;
            p = p.next;
        }
        return len;
    }

     private void printList(Node p){
        while(p!=null){
            System.out.print(p.getData());
            p = p.next;
            if(p != null){
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    private void insertNode(int data){
        Node p;
        p = new Node(data);
        p.setId(id);
        if(head == null){//空表插入
            head = p;
            tail = head;
        }
        else{
            tail.next = p;
            tail =p;
        }
        tail.next = null;
        id++;
    }

    static List createList(){
        List list = new List();
        String str;
        int number;
        Scanner scanner = new Scanner(System.in);

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

}
