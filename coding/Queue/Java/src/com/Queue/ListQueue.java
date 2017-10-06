package com.Queue;
import com.LinkedList.LinkedList;

public class ListQueue {
    private LinkedList list;

    public ListQueue(){
        list = new LinkedList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void enQueue(int value){
        list.pushFront(value);
    }

    public int deQueue(){
        int value = list.popBack();
        return  value;
    }
}
