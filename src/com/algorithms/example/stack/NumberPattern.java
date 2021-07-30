package com.algorithms.example.stack;

import java.util.Stack;

public class NumberPattern {
    public static void main(String[] args) {
        String input1 = "IIDDIDI";
        String input2 = "DDDIDID";
        String res = numberPattern(input2);
        System.out.println(res);
    }

    public static String numberPattern(String inputString) {
        String resultString = "";
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(count);
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i)=='I'){
                while(!stack.isEmpty()) {
                    resultString += stack.pop();
                }
                count++;
                stack.push(count);
            }
            else{
                count = count+1;
                stack.push(count);
            }
        }
        while (!stack.empty()) {
            resultString += stack.pop();
        }
        return resultString;
    }
}
