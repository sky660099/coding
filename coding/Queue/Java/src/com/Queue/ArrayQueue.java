package com.Queue;
import com.Array.LVector;

public class ArrayQueue {
    private LVector array;

    public ArrayQueue(){
        array = new LVector(10);
    }

    public boolean isEmpty(){
        return array.IsEmpty();
    }

    public void enQueue(int value){
        array.Push(value);
    }

    public int deQueue(){
        int value = array.GetValueAt(0);
        array.Delete(0);

        return value;
    }
}
