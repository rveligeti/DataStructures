package com.jcoders.www.CustomUtil;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void functionalTest() {
        Queue<Integer> integerQueue = new Queue<>();
        // get size and verify its zero
        assertEquals(0, integerQueue.size);

        // add 1 item
        integerQueue.add(1);
        assertEquals(1,integerQueue.peek());
        assertEquals(1,integerQueue.size);

        // remove 1 item
        assertEquals(1,integerQueue.remove());
        assertEquals(0, integerQueue.size);

        // add 2 items and remove 2 items
        integerQueue.add(2);
        integerQueue.add(3);
        assertEquals(2,integerQueue.peek());
        assertEquals(2,integerQueue.remove());
        assertEquals(3,integerQueue.peek());
        assertEquals(3,integerQueue.remove());

        // add 5 items and remove 5 items
        integerQueue.add(2);
        integerQueue.add(3);
        assertEquals(2,integerQueue.peek());
        assertEquals(2,integerQueue.remove());
        assertEquals(1, integerQueue.size);
        integerQueue.add(4);
        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);
        assertEquals(3,integerQueue.remove());
        assertEquals(4,integerQueue.remove());
        assertEquals(5,integerQueue.remove());
        assertEquals(6,integerQueue.remove());
        assertEquals(7,integerQueue.remove());
        assertEquals(0, integerQueue.size);



        // add 5 items and remove 3 items


    }

    @Test
    void add() {

    }

    @Test
    void peek() {
    }

    @Test
    void remove() {
    }

    @Test
    void getSize() {
    }
}