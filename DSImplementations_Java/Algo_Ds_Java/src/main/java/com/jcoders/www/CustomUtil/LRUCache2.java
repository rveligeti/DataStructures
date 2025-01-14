package com.jcoders.www.CustomUtil;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class LRUCache2<E,F> {
    int size;
    DataNode<E,F> tail;
    DataNode<E,F> head;

    HashMap<E,DataNode<E,F>> storage;

    public LRUCache2(int size){
        this.size = size;
        storage=new HashMap<E,DataNode<E,F>>();
    }

    public void add(E key, F value){

        if(storage.size() == this.size){
            evict();
        }
        DataNode<E,F> item = new DataNode<>(key, value);
        storage.put(key,item);

        if (head == null && tail == null ){
            tail = item;
            head = item;
            return;
        }
        head.previous = item;
        item.next = head;
        head = item;
    }

    public F get(E var1){
        DataNode<E,F> item = storage.get(var1);
        // if we have single item then no need to modify head or tail.
        // if we access head then no need to modify the list.
        if(storage.size() == 1 || item == head){
            return item.data;
        }
        // if we access the tail element, then its a special case.
        if(item == tail){
            tail = item.previous;
            tail.next = null;
        }
        item.previous = null;
        head.previous = item;
        item.next = head;
        head = item;
        return item.data;
    }

    public void printList(){
        DataNode<E,F> pointer = head;
        StringBuilder test1 = new StringBuilder();
        while (pointer != null){
            test1.append(pointer.address);
            pointer = pointer.next;
        }
        System.out.println(test1);
        pointer = tail;
        StringBuilder test = new StringBuilder();
        while (pointer != null){
            test.append(pointer.address);
            pointer = pointer.previous;
        }
        System.out.println(test);
    }

    public void remove(E key){


    }

    // point tail to tail.previous node and cut off the tail node.
    private void evict(){
        storage.remove(tail.address);
        tail = tail.previous;
        tail.next = null;
    }

    private class DataNode<E,F>{
        E address;
        F data;

        @Getter
        @Setter
        DataNode<E,F> next;

        @Getter
        @Setter
        DataNode<E,F> previous;

        public DataNode(E key, F value){
            this.address = key;
            this.data = value;
            this.next = null;
            this.previous = null;
        }

        @Override
        public int hashCode(){
            return address.hashCode();
        }

    }

}
