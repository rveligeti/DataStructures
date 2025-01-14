package com.jcoders.www.CustomUtil;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
LRU cache with heap.
Insertion :
Retrieval :
*/
public class LRUCache<E,F> {
    Map<E,Node<E,F>> storage;
    int size;
    int priority;
    Queue<Node> priorityOrder;

    public LRUCache(int size){
        this.storage = new HashMap<>();
        this.priorityOrder = new PriorityQueue<>();
        this.size = size;
        this.priority = 1;
    }

    public void add(E key,F value){
        Node<E,F> item = new Node<>(key,value,this.priority);
        storage.put(key,item);
        priorityOrder.add(item);
        this.priority++;
    }

    public F get(E key){
        Node<E,F> temp = storage.get(key);
//        priorityOrder.remove(temp);
        temp.setPriority(this.priority);
        storage.put(temp.key,temp);
//        priorityOrder.add(temp);
        return storage.get(key).data;
    }

    private class Node<E,F> implements Comparable<Node<E,F>>{
        E key;
        F data;
        @Setter
        int priority;
        public Node(E key, F data,int priority){
            this.data = data;
            this.key =  key;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node<E, F> o) {
            if (this.priority == o.priority){
                return  0;
            }
            else if (this.priority > o.priority ){
                return 1;

            }
            else {
                return -1;
            }
        }
    }

}
