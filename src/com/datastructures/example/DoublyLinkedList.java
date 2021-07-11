package com.datastructures.example;

public class DoublyLinkedList {
    NodeforDLL head;
    public static void main (String args[]){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    }
    void insertFront(int data){
        NodeforDLL newNode = new NodeforDLL(data);
        newNode.next =head;
        newNode.prev = null;
        if(head!=null){
            head.prev=newNode;
        }
        head = newNode;
    }
    void insertAfter(){

    }
    void insertEnd(){

    }
    void printList(NodeforDLL node){
        NodeforDLL last = null;
        System.out.println("List in forward direction");
        while(node!=null){
            System.out.print(node.data+" ");
            last = node;
            last = last.next;
        }
        System.out.println();
        System.out.println("List in backward direction");
        while(last!=null){
            System.out.print(node.data+" ");
            last=last.prev;
        }
    }
    void delete(){

    }
}
