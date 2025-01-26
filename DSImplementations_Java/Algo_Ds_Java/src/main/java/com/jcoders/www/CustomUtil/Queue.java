package com.jcoders.www.CustomUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*Supported Operations:
Generic queue Implementation
add -- Add's element to stack.O(1)
remove  -- Removes element from stack. O(1)
Peek -- looks at top element without removing the element.O(1)
size -- returns the number of elements present in the stack.O(1)
*/

@Getter
@NoArgsConstructor
public class Queue<E> {

    private QueueNode head;

    private QueueNode tail;

    @Getter
    public int size;

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
        size++;
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
        size--;
        if (this.size == 0){
            head = null;
            tail = null;
        }
        return temp.data;
    }
}
