package com.algorithms.example.stack.practicerepeated;

import java.util.Stack;

public class CloneStackNew {
    public static void main(String args[]){
        CloneStackNew cloneStackNew = new CloneStackNew();
        Stack<Integer> stack = new Stack<>();
        int n = 6;
        int count = 0;
        for(int i = 0; i<n;i++){
            stack.push(count++);
        }
        for(int i=0;i<n;i++){
            System.out.print(" "+stack.get(i));
        }
        System.out.println();
        Stack<Integer> resultStack = cloneStackNew.cloneStack(stack, 6);
        for(int i=0;i<n;i++){
//                System.out.println("size : " +resultStack.size());
                System.out.print(" "+resultStack.get(i));
        }
    }

    public Stack<Integer> cloneStack(Stack<Integer> stack, int n){
        int count = n;
        Stack<Integer> cloneStack = new Stack<>();
        while(count>0){
            int temp = (int)stack.pop();
            for(int i=0;i<count-1;i++){
                cloneStack.push(stack.pop());
            }
            stack.push(temp);
            while(!cloneStack.isEmpty()){
                stack.push(cloneStack.pop());
            }
            count--;
        }
        while(!stack.isEmpty()){
            cloneStack.push(stack.pop());
        }
        return cloneStack;
    }
}
