package com.jcoders.www.CustomUtil;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeueTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void dequeueFucntionalTest(){
        Dequeue<Integer> queue = new Dequeue<>();

        assertEquals(0, queue.size);

        //add 1 element from font and remove from front
        queue.add(1);
        assertEquals(1,queue.size);
        assertEquals(1, queue.remove());

        //add 1 element from font and remove from back
        queue.add(1);
        assertEquals(1,queue.size);
        assertEquals(1, queue.dequeue());

        //add 2 elements from font and remove from back
        queue.add(1);
        queue.add(2);
        assertEquals(2,queue.size);
        assertEquals(2, queue.dequeue());
        assertEquals(1,queue.size);
        assertEquals(1, queue.dequeue());

        //add 2 elements from font and remove from front
        queue.add(1);
        queue.add(2);
        assertEquals(2,queue.size);
        assertEquals(1, queue.remove());
        assertEquals(1,queue.size);
        assertEquals(2, queue.remove());

        // add 2 elements from back and remove from front
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2,queue.size);
        assertEquals(1, queue.remove());
        assertEquals(1,queue.size);
        assertEquals(2, queue.remove());

        // add 2 elements from back and remove from back
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2,queue.size);
        assertEquals(2, queue.dequeue());
        assertEquals(1,queue.size);
       assertEquals(1, queue.dequeue());

       // 1 font 1 back 1 front 1 back
        queue.add(1);
        queue.enqueue(2);
        queue.add(3);
        queue.enqueue(4);
        queue.add(5);
        queue.enqueue(6);
        queue.add(7);
        queue.enqueue(8);
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
        assertEquals(4, queue.remove());
        assertEquals(5, queue.remove());
        assertEquals(6, queue.remove());
        assertEquals(7, queue.remove());
        assertEquals(8, queue.remove());

        // 1 font 1 back 1 front 1 back
        queue.add(1);
        queue.enqueue(2);
        queue.add(3);
        queue.enqueue(4);
        queue.add(5);
        queue.enqueue(6);
        queue.add(7);
        assertEquals(7, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());

     }

}