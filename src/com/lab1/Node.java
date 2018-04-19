package com.lab1;

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
