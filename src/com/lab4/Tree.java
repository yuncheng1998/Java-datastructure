package com.lab4;

import java.util.Stack;

class Tree {

    class Node {
        private String str;
        Node leftChild, rightChild;
        Node(String str){
            this.str = str;
            leftChild = null;
            rightChild = null;
        }
    }

    Node root;//根节点

    Tree(){
        root = null;
    }
    //非递归算法遍历二叉树
    void inorderNor(){
        Stack<Node> s1 = new Stack<>();
        Node p = root;
        System.out.print("中序遍历: ");
        while(p != null || !s1.isEmpty() ){		//p非空或者栈非空
            if(p!=null){
                s1.push(p);
                p = p.leftChild;
            }
            else{
                p = s1.pop();
                System.out.print(p.str +" ");
                p = p.rightChild;
            }

        }
    }

    void buildTree(Node node, String data){
        if(root == null){
            root = new Node(data);
        }else{
            if( data.compareTo(node.str)<0 ){
                if(node.leftChild == null){
                    node.leftChild = new Node(data);
                }else{
                    buildTree(node.leftChild,data);
                }
            }else if (data.compareTo(node.str)>0 ){
                if(node.rightChild == null){
                    node.rightChild = new Node(data);
                }else{
                    buildTree(node.rightChild,data);
                }
            }
        }

    }
}
