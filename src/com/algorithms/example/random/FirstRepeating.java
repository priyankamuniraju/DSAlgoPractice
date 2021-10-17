package com.algorithms.example.random;

import java.util.HashSet;

public class FirstRepeating {

    public static char firstRepeating(char[] charArray){
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0;i<charArray.length;i++){
            char c = charArray[i];
            if(hashSet.contains(c)){
                return c;
            }
            else{
                hashSet.add(c);
            }
        }
        return '\0';
    }

    public static void main(String[] args){
        String string = "priyankamuniraju";
        char[] charArray = string.toCharArray();
        System.out.println(firstRepeating(charArray));
    }
}
