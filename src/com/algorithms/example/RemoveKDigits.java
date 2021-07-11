package com.algorithms.example;


/**You don't need to read input or print anything.
 * Your task is to complete the function removeKdigits()
 * which takes the string S and an integer K as input and
 * returns the new number which is the smallest possible.
 *
 */
public class RemoveKDigits {

    public static void main(String[] args){
        String str = "1742";
        int k = 2;
        String newString = removeKdigits(str, k);
        System.out.println("After removing "+k +" digits from " +str+" : "+newString);
    }

        static String removeKdigits(String string , int k){

        if(string.length()==k){
            return "0";
        }
        StringBuilder str = new StringBuilder(string);
        for(int i = 0; i<k;i++){
            int j=0;
            if(j< str.length()-1 && (str.charAt(j)<=str.charAt(j+1))){
                j++;

            }
            str.delete(j,j+1);
            }
        //remove leadind 0s
            while(str.length() >1 && str.charAt(0)=='0'){
                str.delete(0,1);
            }
        if(str.length()==0){
            return "0";
        }
        return str.toString();
    }

}
