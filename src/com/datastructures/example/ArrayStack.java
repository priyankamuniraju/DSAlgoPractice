package com.datastructures.example;

public class ArrayStack {
    private int top;
    private int size = 100;
    private int[] stack;

    public ArrayStack(){
        top = -1;
    }

    public ArrayStack(int size){
        top =-1;
        int capacity = size;
        stack = new int[capacity];
    }
    boolean isEmpty(){
        return top < 0;
    }
    public void push(int x){
        if(top>=size){
            System.out.println("Stack Overflow");
        }
        else{
            stack[++top] = x;
//            System.out.println("Top value after push  "+top);
        }
    }

    public  int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            int x = stack[top];
            top = top-1;
//            System.out.println("Top value after pop is "+top);
            return x;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = stack[top];
//            System.out.println("Top value at peek is "+top);
            return x;
        }
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack Empty");
        }
        else{
            System.out.print("Elements in the stack from top to down : ");
            for(int i = size-1 ; i >= 0;i--)
            {
                System.out.print(" " + stack[i]);
            }
            System.out.println();
        }

    }


    public static void main (String[] args){
        ArrayStack stack = new ArrayStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.printStack();

        int ele = stack.peek();
        System.out.println("element at the top is " + ele);

        int d1 = stack.pop();
        System.out.println("deleted ele is " + d1);

        int ele2 = stack.peek();
        System.out.println("element at the top after pop is " + ele2);

//        int newArray = stack.nextLargeElement();

    }

    public int size() {
        return size;
    }
}
