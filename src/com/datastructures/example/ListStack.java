package com.datastructures.example;

public class ListStack {
    Node top;
    ListStack(){
        top=null;
    }
    class Node{
        int data;
        Node next;
    }

    boolean isEmpty(){
        return(top == null);
    }

    //push front
    void push(Integer x){
        Node temp = new Node();
        temp.data = x;
        temp.next = top;
        top = temp;
    }

    //pop front
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Empty, no elements to delete");
            return -1;
        }
        else{
            int deletedEle = top.data;
            top = top.next;
            return deletedEle;
        }
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return -1;
        }
        else{
           return top.data;
        }
    }

    public static void main(String[] args){
        ListStack sll = new ListStack();
        sll.push(10);
        sll.push(20);
        sll.push(30);
        sll.push(40);
        sll.push(50);
        sll.push(60);
        sll.push(70);
        int ele1 = sll.peek();
        System.out.println("Ele at the top ="+ele1);
        int ele2 = sll.pop();
        System.out.println("Popped ele ="+ele2);
        int ele3 = sll.peek();
        System.out.println("Ele at the top ="+ele3);
    }
}
