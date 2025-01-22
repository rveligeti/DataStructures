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
        Assert.assertTrue(integerQueue.getSize() == 0);

        // add 1 item
        integerQueue.add(1);
        Assertions.assertEquals(1,integerQueue.peek());
        Assertions.assertEquals(1,integerQueue.getSize());

        // remove 1 item
        Assertions.assertEquals(1,integerQueue.remove());
        Assert.assertTrue(integerQueue.getSize() == 0);

        // add 2 items and remove 2 items
        integerQueue.add(2);
        integerQueue.add(3);
        Assertions.assertEquals(2,integerQueue.peek());
        Assertions.assertEquals(2,integerQueue.remove());

        // add 5 items and remove 5 items


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