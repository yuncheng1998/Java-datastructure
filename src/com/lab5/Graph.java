package com.lab5;

import java.util.ArrayList;
import java.util.Stack;

class Graph {
    class ActivityNode { //表节点
        int head, tail;
        ActivityNode headLink;
        ActivityNode tailLink;
    }
    class VertexNode {  //弧节点
        int data;
        ActivityNode fIn;
        ActivityNode fOut;

        VertexNode(int data) {
            this.data = data;
            this.fIn = null;
            this.fOut = null;
        }
    }
    private ArrayList<VertexNode> vertexNodes = new ArrayList<>();

    ArrayList<VertexNode> createList(ArrayList<Integer> data, ArrayList<String> relationship) {
        int vi = 0, vj = 0; //对应顶点表的序号
        //输入节点
        for (Integer aData : data) {
            VertexNode vertexNode = new VertexNode(aData);
            vertexNode.fIn = vertexNode.fOut = null;
            vi++;
            vertexNodes.add(vertexNode);
        }
        for (String road : relationship) {
            String[] strings = road.split(",");
            for (int i = 0; i < vertexNodes.size(); i++) {
                if (vertexNodes.get(i).data == Integer.parseInt(strings[0])) {
                    vi = i;
                    break;
                }
            }
            for (int i = 0; i < vertexNodes.size(); i++) {
                if (vertexNodes.get(i).data == Integer.parseInt(strings[1])) {
                    vj = i;
                    break;
                }
            }
            ActivityNode p = new ActivityNode();
            p.tail = vi;
            p.head = vj;
            p.headLink = vertexNodes.get(vj).fIn;
            vertexNodes.get(vj).fIn = p;
            p.tailLink = vertexNodes.get(vi).fOut;
            vertexNodes.get(vi).fOut = p;
        }
        return vertexNodes;
    }
    private void createId(ArrayList<VertexNode> vertexNodes, int n, int[] id) {
        int count,i;
        ActivityNode p = new ActivityNode();
        for(i = 0; i < n; i++) {
            count = 0;
            p = vertexNodes.get(i).fIn;
            while(p != null) {
                count ++;
                p = p.headLink;
            }
            id[i] = count;
        }
    }

    void topSort(ArrayList<VertexNode> vertexNodes) {
        Stack<Integer> stack = new Stack<>();
        int l,j,k,count;
        int[] id = new int[100];
        ActivityNode activityNode;
        createId(vertexNodes, vertexNodes.size(), id);
        while (!stack.empty()) {
            stack.pop();
        }

        for (l = 0; l < vertexNodes.size(); l++){
            if (id[l] == 0) {
                stack.push(l);
            }
        }

        count = 0;
        while(!stack.empty()) {
            j = stack.peek();
            stack.pop();
//            System.out.println("序号为" + j + "的点值为：" + vertexNodes.get(j).data);
            count++;
            activityNode = vertexNodes.get(j).fOut;
            while (activityNode != null) {
                k = activityNode.head;
                id[k]--;
                if (id[k] == 0) {
                    stack.push(k);
                    activityNode = activityNode.tailLink;
                }
            }
        }
        if(count == vertexNodes.size())
            System.out.println("无环图");
        else
            System.out.println("有环图");


    }


}
