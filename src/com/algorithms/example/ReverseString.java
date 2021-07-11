package com.algorithms.example;

/**
 * You don't need to read input or print anything.
 * Your task is to complete the function reverseWords()
 * which takes the string S as input and returns
 * the resultant string by reversing all the words separated by dots.
 */
public class ReverseString {

    public static String reverseString(String inputString){
        String s = "";
        for(int i=inputString.length()-1;i>=0;i--){
            s+=inputString.charAt(i);
        }
        return s;
    }

    public static String reverseRecursive(String input){
        if(input.length()<=0){
            return "";
        }
        else{
            return (input.charAt(input.length()-1)+reverseRecursive(input.substring(0,(input.length()-1))));
        }
    }

    public static void main(String[] args){
        String input = "PRI.JAG.ARI";
        System.out.println("Input string : "+input);
        String rs, result= "";
        String[] arr = input.split("[.]");
        for(int j=0;j<arr.length;j++){
            System.out.print(" "+arr[j]);
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            /**Iterative reverse**/
            //rs = reverseString(arr[i]);
            /**Recursive reverse**/
             rs = reverseRecursive(arr[i]);
             result += rs;
             if(i<arr.length-1){
                 result+=".";
             }
        }
        System.out.println("Reverse string :" + result);

    }
}
