package com.algorithms.example.stack.practicerepeated;

import java.util.Stack;

public class NextLargerElementNew {
    public static void main(String[] args){
        int[] array = {6,8,0,1,3};
        int[] resultArray = nextLargerElementNew(array);
    }

    static int[] nextLargerElementNew(int[] array){
        Stack<Integer> stack = new Stack<>();
        int[] resultArray = new int[array.length];
        stack.push(-1);
        for(int i=array.length-1; i>=0;i--){
            while (true) {
                int top = stack.peek();
                if(top==-1 ||array[i]<top){
                    resultArray[i]=top;
                    stack.push(array[i]);
                    break;
                }
                else if(array[i] > top){
                    stack.pop();
                }
            }
        }
        return resultArray;
    }
}
