package com.algorithms.example.random;

// Java program to find the first
// repeated character in a string
import java.util.*;

class FirstRepeatingCharInString {
    // This function prints the first repeated
    // character in str[]
    static char firstRepeating(char charArray[])
    {
        // Creates an empty hashset
        HashSet<Character> hashset = new HashSet<>();

        // Traverse the input array from left to right
        for (int i=0; i<=charArray.length-1; i++)
        {
            char c = charArray[i];

            // If element is already in hash set, update x
            // and then break
            if (hashset.contains(c))
                return c;

            else // Else add element to hash set
                hashset.add(c);
        }

        return '\0';
    }

    // Driver method to test above method
    public static void main (String[] args)
    {
        String string = "priyankamuniraju";
        char[] arr = string.toCharArray();
        System.out.println(firstRepeating(arr));
    }
}
