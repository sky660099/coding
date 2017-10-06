package com.LinkedList;

class LinkedListNode{
    private int data;
    private LinkedListNode next;

    public LinkedListNode(int value, LinkedListNode node){
        data = value;
        next = node;
    }

    public int getData(){
        return data;
    }

    public void setNext(LinkedListNode node){
        next = node;
    }

    public LinkedListNode getNext(){
        return next;
    }
}


public class LinkedList {
    private int size = 0;
    private LinkedListNode header;
    private LinkedListNode tail;

    public LinkedList(){
        size = 0;
        header = null;
        tail = null;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else{
            return false;
        }
    }

    public int getValueAt(int index){
        if (index > size - 1 || index < 0){
            System.out.println("index out of bound");
            System.exit(0);
        }

        LinkedListNode tmp = header;

        for (int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }

        return tmp.getData();
    }

    public void pushFront(int value){
        LinkedListNode newNode = new LinkedListNode(value, header);
        header = newNode;
        size++;

        if (size == 1){
            tail = newNode;
        }
    }

    public int popFront(){
        if (isEmpty() == true){
            System.out.println("index out of bound");
            System.exit(0);
        }

        int value = header.getData();
        header = header.getNext();
        size--;

        if (size == 0){
            tail = null;
        }

        return value;
    }

    public void pushBack(int value){
        LinkedListNode newNode = new LinkedListNode(value, null);
        tail.setNext(newNode);
        tail = newNode;
        size ++;
    }

    public int popBack(){
        if (isEmpty() == true){
            System.out.println("index out of bound");
            System.exit(0);
        }

        int value = tail.getData();
        LinkedListNode tmp = header;

        for (int i = 0; i < size-2; i++){
            tmp = tmp.getNext();
        }

        tail = tmp;
        size--;

        if (size == 0){
            header = null;
            tail = null;
        }

        return value;
    }

    public int getFront(){
        if (isEmpty() == true){
            System.out.println("index out of bound");
            System.exit(0);
        }

        return header.getData();
    }

    public int getBack(){
        if (isEmpty() == true){
            System.out.println("index out of bound");
            System.exit(0);
        }

        return tail.getData();
    }

    public void insert(int index, int value){
        if (index > size || index < 0){
            System.out.println("index out of bound");
            System.exit(0);
        }

        if (index == 0){
            pushFront(value);
        }else if (index == size){
            pushBack(value);
        }else {
            LinkedListNode newNode = new LinkedListNode(value, null);
            LinkedListNode tmp = header;

            for (int i = 0; i < index - 1; i++){
                tmp = tmp.getNext();
            }

            newNode.setNext(tmp.getNext());
            tmp.setNext(newNode);

            size++;
        }
    }

    public void erase(int index){
        if (index > size - 1 || index < 0){
            System.out.println("index out of bound");
            System.exit(0);
        }

        if (index == 0){
            popFront();
        }else if (index == size-1){
            popBack();
        }else {
            LinkedListNode tmp = header;

            for (int i = 0; i < index - 1; i++){
                tmp = tmp.getNext();
            }

            tmp.setNext(tmp.getNext().getNext());
            size--;
        }
    }

    public int getValueFromEnd(int index){
        if (index > size - 1 || index < 0){
            System.out.println("index out of bound");
            System.exit(0);
        }

        LinkedListNode tmp = header;

        for (int i = 0; i < size-index-1; i++){
            tmp = tmp.getNext();
        }

        return tmp.getData();
    }

    public void reverse(){
        LinkedListNode preNode = null;
        LinkedListNode nextNode = header;

        LinkedListNode tmp;

        for (int i = 0; i < size; i++){
            tmp = nextNode;
            nextNode = tmp.getNext();
            tmp.setNext(preNode);
            preNode = tmp;
        }

        tmp = tail;
        tail = header;
        header = tmp;
    }

    public void removeValue(int value){
        LinkedListNode tmp = header;
        for (int i = 0; i < size; i++){
            if (tmp.getData() == value){
                erase(i);
                break;
            }

            tmp = tmp.getNext();
        }
    }

    public void debugString(){
        System.out.println(size);

        LinkedListNode tmp = header;

        for (int i = 0; i < size; i++){
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }

        System.out.println(" ");
    }
}
