package com.lab3;

class Queue {

    private Node front, rear;

    Queue(){
        front = null;
        rear = null;
    }

    class Node {
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
        else
            front = node;
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
