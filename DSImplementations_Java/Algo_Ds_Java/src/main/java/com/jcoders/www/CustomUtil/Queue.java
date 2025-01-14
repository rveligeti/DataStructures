package com.jcoders.www.CustomUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*Supported Operations:
Generic Stack Implementation
add -- Add's element to stack.O(n)
remove  -- Removes element from stack. O(1)
Peek -- looks at top element without removing the element.O(1)
size -- returns the number of elements present in the stack.O(1)
*/

@NoArgsConstructor
public class Queue<E> {

    private QueueNode head;

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

    public void add(E data){
        Size++;
        if(head == null ){
            head = new QueueNode(data,null);
        }
        else{
            QueueNode temp = head;
            while (temp.next!= null){
                temp = temp.next;
            }
            temp.next = new QueueNode(data,null);
        }
    }

    public E remove(){
        QueueNode temp = head;
        head = head.next;
        Size--;
        return temp.data;
    }

}
