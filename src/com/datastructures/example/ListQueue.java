package com.datastructures.example;

public class ListQueue {
    QueueNode front, rear;

    static class QueueNode{
        int data;
        QueueNode next;
    }

    ListQueue(){
        front = rear = null;
    }

    //insert at the rear
    void enqueue(int x){
        QueueNode temp = new QueueNode();
        temp.data=x;
        if(rear==null){
            front=rear=temp;
        }
        else {
            rear.next = temp;
            rear = temp;
        }
    }

    //delete from the front
    void dequeue(){
        if(front==null){
            return;
        }
        else{
//            QueueNode temp = front;
            front = front.next;
        }
        if(front==null){
            rear=null;
        }
    }

    public static void main(String[] args){
        ListQueue listQueue = new ListQueue();
        listQueue.enqueue(10);
        listQueue.enqueue(20);
        listQueue.enqueue(30);
        listQueue.enqueue(40);
        listQueue.enqueue(50);
        listQueue.enqueue(60);
        listQueue.enqueue(70);
        listQueue.dequeue();
        System.out.println("Queue Front : " + listQueue.front.data);
        System.out.println("Queue Rear : " + listQueue.rear.data);
    }
}
