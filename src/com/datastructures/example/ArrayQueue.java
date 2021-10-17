package com.datastructures.example;

public class ArrayQueue {
    int front;
    int rear;
    int capacity;
    int[] queue ;

    ArrayQueue(int size){
        front=rear=0;
        capacity= size;
        queue = new int[capacity];
    }
    boolean isEmpty(){
        return (front==rear);
    }

    //add from the back/rear
    void enqueue(int x){
        if( rear==capacity){
            System.out.println("Queue Full");
        }
        else{
            queue[rear] = x;
            rear++;
        }
    }

    //delete from the front
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue empty");
            return -1;
        }
        else{
            int e= queue[front];
            rear--;
            for(int i =0;i<capacity-1;i++){
                queue[i]=queue[i+1];
            }
            if(rear<capacity){
                queue[rear]=0;
            }
            return e;
        }
    }

    void display(){
    if(isEmpty()){
        System.out.println("Queue is empty");
    }
    else{
        for(int i=0;i<capacity;i++){
            System.out.print(" "+queue[i]);
        }
        }
    }

    int showFront(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            return (queue[front]);
        }
    }

    public static void main(String[] args){
        ArrayQueue queueUsingArray = new ArrayQueue(7);
        queueUsingArray.enqueue(10);
        queueUsingArray.enqueue(20);
        queueUsingArray.enqueue(30);
        queueUsingArray.enqueue(40);
        queueUsingArray.enqueue(50);
        queueUsingArray.enqueue(60);
        queueUsingArray.enqueue(70);

        queueUsingArray.display();

        int delEle = queueUsingArray.dequeue();
        System.out.println();
        System.out.println("Deleted ele :"+delEle);

        queueUsingArray.display();

        System.out.println();
        int frontEle = queueUsingArray.showFront();
        System.out.println("Front ele :"+frontEle);

        queueUsingArray.display();

        int delEle1 = queueUsingArray.dequeue();
        System.out.println();
        System.out.println("Deleted ele :"+delEle1);

        queueUsingArray.display();

    }
}
