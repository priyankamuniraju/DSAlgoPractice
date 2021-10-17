package com.algorithms.example.simplealgorithms;

public class Palindrome {
    public static void main(String args[]){
        String stringOne = "abba";
        String stringTwo = "priya";
        boolean isPalindrome = checkPalindrome(stringTwo);
        System.out.println("The given string is panlindrome true/false: "+isPalindrome);
    }

    public static boolean checkPalindrome(String string){
        char[] charArray = string.toCharArray();
        int i = 0;
        int j= string.length()-1;
                while(i<j) {
                    if (charArray[i] != charArray[j]) {
                        return false;
                    }
                    i++;
                    j--;
                }
                return true;
    }
}
