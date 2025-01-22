package com.jcoders.www.CustomUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*Supported Operations:
Generic queue Implementation
add -- Add's element to stack.O(n) -- we need to fix this we need to have O(1) for add as well.
remove  -- Removes element from stack. O(1)
Peek -- looks at top element without removing the element.O(1)
size -- returns the number of elements present in the stack.O(1)
*/

//fix the queue implementation we need to have O(1) for both push and pop operations

@NoArgsConstructor
public class Queue<E> {

    private QueueNode head;

    private QueueNode tail;

    @Getter
    private int Size;

    private class QueueNode{
        private E data;
        private QueueNode next;
        public QueueNode(E data, QueueNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // adds an element to the end of the queue
    public void add(E data){
        Size++;
        if(head == null ){
            // this is the first node point both head and tail to the first node.
            head = new QueueNode(data,null);
            tail = head;
        }
        else{
            // tail always points to the end of the list.
            // add the new node to the end of the list.
            QueueNode newNode = new QueueNode(data,null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    // returns the data of the first element
    public E peek(){
        return head.data;
    }

    // removes the first element and returns the data
    public E remove(){
        QueueNode temp = head;
        head = head.next;
        Size--;
        if (this.getSize() == 0){
            head = null;
            tail = null;
        }
        return temp.data;
    }
}
