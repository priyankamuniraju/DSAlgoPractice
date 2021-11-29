package com.algorithms.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {
    public static void main(String args[]){
        String str = "aaabcbd";
        char[] result = new char[str.length()];
        result = firstNonRepeatingCharacter(str) ;
        for(int i = 0 ; i<result.length;i++){
            System.out.print(" "+result[i]);
        }
    }

    public static char[] firstNonRepeatingCharacter(String string){
        char[] charArray = string.toCharArray();
        char[] outArray = new char[charArray.length];
        Queue<Character> queue = new LinkedList<Character>();
        int cr = 0;
        for(int i=0;i<charArray.length;i++){
            if(!queue.isEmpty() && charArray[i]==queue.peek()) {
                outArray[i] = '#';
                cr = 1;
            }

            else {
                if (cr == 1) {
                    queue.remove();
                    cr = 0;
                }
                    queue.add(charArray[i]);
                    outArray[i] = queue.peek();
                }
        }
        return outArray;
    }
}
