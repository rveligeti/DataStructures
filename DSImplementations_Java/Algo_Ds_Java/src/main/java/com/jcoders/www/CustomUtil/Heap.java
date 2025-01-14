package com.jcoders.www.CustomUtil;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<E> {

    ArrayList<E> storage;
    int endPointer;
    @Setter
    Comparator<E> comparator;

    public Heap(){
        this.endPointer = -1;
        this.storage = new ArrayList<>(10);
    }

    public Heap(Comparator<E> comparator){
        this();
        this.comparator = comparator;
    }

    // child 1 2(index) + 1
    //child 2 2(index) + 2
    // removes top item from heap
    public E top(){
        E temp = storage.get(0);
        storage.add(0,storage.get(this.endPointer));
//        rebalance_from_top();
        return temp;
    }

//    private void rebalance_from_top(){
//        int currentIndex = 0;
//        while( currentIndex <= endPointer ){
//             int leftChild = ( 2* currentIndex ) +1;
//             Integer.min(storage.get(2*currentIndex))
//
//        }
//    }

    // adds an item to the heap
    public void add(E item){
        if(this.endPointer == this.storage.size() -1 ){
            this.storage.add(item);
            this.endPointer++;
        }
        else{
            this.storage.add(this.endPointer++,item);
        }
        rebalance_from_bottom();
    }

    // odd node parent = (node index - 1)/2
    // even node parent = (node index - 2)/2
    // todo use comparator when passed
    // todo use compare operation based on type of E and remove casting to integer
    private void rebalance_from_bottom(){
        int parent = parent(this.endPointer);
        int currentNode =  this.endPointer;
        while (parent >= 0){
            if( (Integer)this.storage.get(currentNode) < (Integer) this.storage.get(parent) ){
                E temp = this.storage.get(currentNode);
                this.storage.add( currentNode, this.storage.get(parent));
                this.storage.add(parent,temp);
                currentNode = parent;
                parent = parent(parent);
            }
            else {
                parent = -1;
            }
        }
    }

    private int parent(int childIndex){

        if( (childIndex%2) == 0 ){
            return (childIndex - 2) / 2;
        }
        else {
            return (childIndex - 1) / 2;
        }
    }
}
