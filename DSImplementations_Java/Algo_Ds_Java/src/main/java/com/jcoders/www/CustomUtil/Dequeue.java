package com.jcoders.www.CustomUtil;


/*double ended Queue which is a combination of both stack and queue interfaces
add() add the front of the queue
remove() remove from front of the queue
enqueue() add at the end of the queue
dequeue() remove from the end of the queue
size() returns the number of elements in the queue
*/

import lombok.Getter;

public class Dequeue<E> {

    private Node head;
    private Node tail;

    @Getter
    public int size;

    private class Node{
        E data;
        Node next;
        Node previous;
        public Node (E data,Node previous, Node next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(E data){
        //if the queue is empty both head and tail point to the first element
        Node current = new Node(data,null,null);
        if ( this.size == 0 ){
            this.head = current;
            this.tail = current;
        }
        else{
            // if the queue is not empty we need to add the element at the end.
            // i.e tail will point to the new node and we adjust both next and previous
            tail.next = current;
            current.previous = tail;
            tail = current;
        }
        this.size++;
    }

    public E peek(){
        return this.head.data;

    }

    public E peekTail(){
        return this.tail.data;
    }

    public E remove(){
        E tempData = tail.data;
        if(this.size == 1 ){
            // if we only have 1 element in queue we need to make sure tail and head are pointing to null
            head = null;
            tail = null;
        }
        else {
            // point the head to the second element in the list
            // remove link to previous element from the new head
            tempData = head.data;;
            head = head.next;
            head.previous = null;
        }
        size--;
        return  tempData;
    }

    public void enqueue(E data){
        if (size == 0){
            this.add(data);
        }
        else{
            // create a new element with previous as tail
            // add the point tail.next to new element
            // make tail point to current element
            Node temp = new Node(data,tail,null);
            tail.next = temp;
            tail = temp;
            this.size++;
        }
    }

    public E dequeue(){
        if(this.size == 1){
            return this.remove();
        }
        else {
            // tail points to tail.previous
            // tail.next will become null
            E temp = tail.data;
            tail = tail.previous;
            tail.next = null;
            this.size--;
            return temp;
        }
    }

}
