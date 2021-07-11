package com.algorithms.example;
/**You don't need to read input or print anything.
 Your task is to complete the function clonestack()
 which takes the input stack st[], an empty stack cloned[],
 you have to clone the stack st into stack cloned.
 The driver code itself prints 1 in the output if
 the stack st is cloned properly and prints 0 otherwise.**/

import com.datastructures.example.ArrayStack;

public class CloneStackNoExtraSpace {


    public static void main(String[] args){
        ArrayStack stack = new ArrayStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.print("Original Stack  :");
        stack.printStack();

        ArrayStack cloneStack = new ArrayStack();

        ArrayStack returnStack = cloneStack(stack,cloneStack);

        System.out.print("Cloned Stack  :");
        returnStack.printStack();

    }



    static ArrayStack cloneStack(ArrayStack stack, ArrayStack cloneStack){
        int count = 0;
        int n = stack.size();
        while(count <= n){
                int topVal = stack.pop();
                for(int i =0;i<n-count-1;i++){
                    int x = stack.pop();
                    cloneStack.push(x);
                }
                stack.push(topVal);
                for(int j = 0; j<n-count-1;j++){
                    int y=cloneStack.pop();
                    stack.push(y);
                }
        count++;
        }
        for(int k =0;k<n;k++){
            int z=stack.pop();
            cloneStack.push(z);
        }

       return cloneStack;
    }

}
