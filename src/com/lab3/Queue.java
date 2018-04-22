package com.lab3;

class Queue {

    private Node front, rear;

    Queue() {       //构造Queue初始状态front和rear为null，判断Queue是否为空
        front = null;
        rear = null;
    }

    class Node {        //将Node封装在Queue中成为内部类，由Queue类的处理Node
        private char data;
        Node next;

        Node(char data){
            this.data = data;
            next = null;
        }

        char getChar() {
            return data;
        }
    }

    boolean isEmpty(){
        return this.rear != null || this.front != null;
    }

    void enQueue(char c){	//入队
        Node node = new Node(c);
        if(isEmpty())
            rear.next = node;
        else {
            front = node;
        }
        rear = node;
    }

    char deQueue() {	//出队
        char c = 0;
        if(isEmpty()){
            c = front.getChar();
            front = front.next;
            if(front == null)
                rear = null;
        }
        return c;
    }
}
