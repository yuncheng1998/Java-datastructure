package com.lab1;

class List {

    private int id = 1;

    private Node head,tail;//头结点和尾节点

    List(){
        head = null;
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

     void printList(Node p){
        while(p!=null){
            System.out.print(p.getData());
            p = p.next;
            if(p != null){
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    void insertNode(int data){
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
        id++;
        tail.next = null;
    }
}
