package com.algorithms.example.simplealgorithms;
import java.util.*;

public class DuplicateWordsInString
{
    static void duplicateWords(String inputString)
    {
        String[] words = inputString.split(" ");

        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        for (String word : words)
        {
            if(wordCount.containsKey(word.toLowerCase()))
            {
                wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase())+1);
            }
            else
            {
                wordCount.put(word.toLowerCase(), 1);
            }
        }

        Set<String> wordsInString = wordCount.keySet();

        for (String word : wordsInString)
        {
            if(wordCount.get(word) > 1)
            {
                System.out.println(word+" : "+wordCount.get(word));
            }
        }
    }

    public static void main(String[] args)
    {
        duplicateWords("Bread butter and bread");

        duplicateWords("Java is java again java");

        duplicateWords("Super Man Bat Man Spider Man");
    }
}
