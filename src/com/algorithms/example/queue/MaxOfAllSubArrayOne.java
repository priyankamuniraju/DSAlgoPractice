package com.algorithms.example.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MaxOfAllSubArrayOne {
    public static void main(String[] args){
        int[] arr = {1,2,3,1,4,5,2,3,6};
        int arraySize = 9;
        int subArraySize = 3;
//        maxOfAllSubArray(arr,arraySize,subArraySize);
        findMaxAndPrint();
    }

    public static void findMaxAndPrint(){
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(7);

        Iterator<Integer> itr = q.iterator();
        int max = 0;
        while(itr.hasNext()){
            if(itr.next() > max){
                max = itr.next();
            }
        }
        System.out.println(" "+max);
    }

    public static void maxOfAllSubArray(int[] array, int arraySize, int subArraySize){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<arraySize;i++){
            if(queue.isEmpty()){
                for(int j=0; j<3;j++){
                    queue.add(array[j]);
                }
            }
//            findMaxAndPrint(queue);

            Object ob;
            System.out.println("...Queue elements...");
            while ((ob = queue.poll()) != null) {
                System.out.println(ob);
            }
                queue.remove();
                queue.add(array[i+subArraySize]);

            }
        }
    }

