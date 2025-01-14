package com.jcoders.www.CustomUtil;

/*Supported Operations:
Generic Stack Implementation
Push -- Add's element to stack.O(1)
Pop  -- Removes element from stack. O(1)
Peek -- looks at top element without removing the element.O(1)
size -- returns the number of elements present in the stack.O(1)
*/
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Stack<E> {
    private StackNode<E> head;
    private E data;

    private class StackNode<E>{

        private StackNode<E> next;
        private E data;

        public StackNode(E data,StackNode<E> next ) {
            this.next = next;
            this.data = data;
        }
    }

    public Stack(E data) {
        head = new StackNode<>(data, null);
        size++;
    }

    @Getter
    private int size;
    public void Push(E var){
        head = new StackNode<>(var, head);
        size++;
    }
    public E Pop(){
        StackNode<E> temp = head;
        head = head.next;
        size--;
        return temp.data;
    }
    public E Peek(){
        return head.data;
    }
}
