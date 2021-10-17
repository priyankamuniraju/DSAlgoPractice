package com.blog.research.example;

import java.util.Arrays;
import java.util.Collection;

public class GenericMethodExampleOne {
    public static void main(String[] args){
        Collection<Integer> collectionObj = Arrays.asList(1,2,3,4);
        int count = Algorithm.count(collectionObj, OddPredicate.getInstance());
        System.out.println("Number of odd integers :"+count);
        Collection<String> mySentence = Arrays.asList("if", "my", "back", "is", "hurting", "if", "my", "husband", "is", "mean");
        System.out.println("Number of ifs = " + Algorithm.count(mySentence, new IfPredicate()));

        Integer[] arr = new Integer[]{10,20,30,40,50};
        String[] array2 = new String[] {"a","b","c","d"};
        swapTwoElementsInAnArray(arr, 1,2);
        swapTwoElementsInAnArray(array2,1,2);
        System.out.println("Swapped Array");
     for(int i = 0;i<arr.length;i++){
         System.out.println(arr[i]);
     }
    }
    //Given an array and two positions in it. Swap the two positions.
    public static <T> void swapTwoElementsInAnArray(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }
}

final class Algorithm {
    public static <T> int count(Collection<T> c, Predicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
}
class OddPredicate implements Predicate<Integer> {
    //By making the constructor private we are blocking many instance creation and ensuring it is singleton
    private OddPredicate() {
        //deliberate
    }
    //by creating the instance inside an inner class we make sure that the instance
    // is not created until there is a reference to the class(in this case until somebody calls getInstance method)
    private static class OddPredicate_Holder {
        private static final OddPredicate My_Predicate = new OddPredicate();
    }
    //below method of instantiating will cause resource creation even before
    // class is loaded as it is a static member(this causes problems if
    // there are resources like DB connections which have state)
    //private static OddPredicate myPredicate = new OddPredicate();

    public static OddPredicate getInstance() {
        return OddPredicate_Holder.My_Predicate;
    }
    public boolean test(Integer i) {
        return i % 2 != 0;
    }
}

class IfPredicate implements Predicate<String> {
    @Override
    public boolean test(String obj) {
        return obj.contains("if") || obj.contains("IF") || obj.contains("iF") || obj.contains("If");
    }
}

