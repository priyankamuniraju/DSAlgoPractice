package com.datastructures.example;

public class ArrayStack {
    private int top;
    private int size = 5;
    private int[] array = new int[size];

    public ArrayStack(){
        top =-1;
    }
    boolean isEmpty(){
        return top < 0;
    }
    public void push(int x){
        if(top>=size){
            System.out.println("Stack Overflow");
        }
        else{
            array[++top] = x;
//            System.out.println("Top value after push  "+top);
        }
    }

    public  int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            int x = array[top];
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
            int x = array[top];
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
                System.out.print(" " + array[i]);
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
