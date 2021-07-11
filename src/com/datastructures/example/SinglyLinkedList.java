package com.datastructures.example;

import org.w3c.dom.Node;

public class SinglyLinkedList {
    NodeforSLL head;
    public static void main(String args[]){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll = insertEle(sll,10);
        sll = insertEle(sll,20);
        sll = insertEle(sll,30);
        sll = insertEle(sll,40);
        sll = insertEle(sll,50);
        sll = insertEle(sll,60);

        System.out.println("The Singly Linked List");
        printList(sll);
        SinglyLinkedList singlyLinkedList = deleteEle(sll,3);
        System.out.println("The List after deletion of an element");
        printList(singlyLinkedList);
        NodeforSLL reverseSLL = reverseList(sll.head);
        System.out.println();
        System.out.println("The List after reversal of elements");
        printListNode(reverseSLL);


    }

    public static SinglyLinkedList insertEle(SinglyLinkedList list , int ele){

        NodeforSLL newNode = new NodeforSLL(ele);
        newNode.next=null;
        //if list is empty
        if(list.head==null){
            list.head = newNode;
        }
        else{
            NodeforSLL last = list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next = newNode;
        }
        return  list;
    }

    public static void printList(SinglyLinkedList list){
        NodeforSLL currentNode = list.head;
        while(currentNode!=null){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
        }
    }

    public static void printListNode(NodeforSLL node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }

    public static SinglyLinkedList deleteEle(SinglyLinkedList list, int index){

        NodeforSLL currentNode = list.head;
        NodeforSLL prev = null;
        if(index==0 && currentNode!=null){
            list.head=currentNode.next;
            System.out.println();
            System.out.println(index+" position ele deleted.");
            return list;
        }

            int count = 0;
            while(currentNode!=null){
                if(count!=index){
                    prev=currentNode;
                    currentNode=currentNode.next;
                    count++;
                }
                else{
                    prev.next = currentNode.next;
                    System.out.println();
                    System.out.println("Element " +currentNode.data+ " at position " +index+ " is deleted.");
                    break;
                }
            }
        if(currentNode==null){
            System.out.println("No element found at the position "+index);
        }
        return list;
    }


    public static NodeforSLL reverseList(NodeforSLL head){
        NodeforSLL curNode = head;
        NodeforSLL previous = null;
        NodeforSLL next = null;
        while(curNode!=null){
            next = curNode.next;
            curNode.next= previous;
            previous = curNode;
            curNode = next;
        }
        return previous;
    }

}
