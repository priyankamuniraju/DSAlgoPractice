package com.algorithms.example.stack;

import com.datastructures.example.ArrayStack;

import java.util.Stack;

public class InfixtoPostfix {

    public static void main(String[] args) {
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixtopostfix(input));
    }

    public static String infixtopostfix(String inputString) {
        String resultStr = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (isAlphabet(c)) {
                resultStr += c;
            } else if (isOperator(c)) {
                int preC = precendence(c);
                while (!stack.isEmpty()) {
                    char peek = stack.peek();
                    int preP = precendence(peek);
                    if (preC > preP || c == '(') {
                        stack.push(c);
                        break;
                    } else {
                        resultStr += stack.pop();
                    }
                }

                if (stack.isEmpty()) {
                    stack.push(c);
                }
            } else if (c == ')') {
                while (!stack.empty()) {
                    char pop = stack.pop();
                    if (pop != '(') {
                        resultStr += pop;
                    } else {
                        break;
                    }
                }
            }
        }

        while (!stack.empty()) {
            resultStr += stack.pop();
        }
        return resultStr;
    }

    public static boolean isAlphabet(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
    }

    public static boolean isOperator(char c) {
        return (c == '^' || c == '*' || c == '/' || c == '+' || c == '-' || c == '(');
    }

    static int precendence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            case '(':
                return 0;
            case ')':
                return 0;
        }
        return 0;
    }
}

