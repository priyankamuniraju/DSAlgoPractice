package com.datastructures.example;

public class LinkedListQueue {
    QueueNode front, rear;

    class QueueNode{
        int data;
        QueueNode next;
    }

    LinkedListQueue(){
        front = rear = null;
    }

    void enqueue(int x){
        QueueNode temp = new QueueNode();
        if(rear==null){
            front=rear=temp;
            return;
        }
        else {
            rear.next = temp;
            rear = temp;
        }
    }
    void dequeue(){
        if(front==null){
            return;
        }
        else{
            QueueNode temp = front;
            front = front.next;
        }
        if(front==null){
            rear=null;
        }

    }

    public static void main(String[] args){
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(50);
        linkedListQueue.enqueue(60);
        linkedListQueue.enqueue(70);
        linkedListQueue.dequeue();
        System.out.println("Queue Front : " + linkedListQueue.front.data);
        System.out.println("Queue Rear : " + linkedListQueue.rear.data);
    }
}
