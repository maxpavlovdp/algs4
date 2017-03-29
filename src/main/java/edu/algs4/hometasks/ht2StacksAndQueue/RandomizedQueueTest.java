package edu.algs4.hometasks.ht2StacksAndQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Max_account on 3/21/17.
 */
public class RandomizedQueueTest {
    RandomizedQueue<Integer> rQueue;


    @Before
    public void setUp() throws Exception {
        this.rQueue = new RandomizedQueue<Integer>();
    }

    @Test
    public void dequeueOne() {
        rQueue.enqueue(5);
        assertEquals(new Integer(5), rQueue.dequeue());
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeueWhenEmpty() {
        rQueue.enqueue(5);
        rQueue.dequeue();
        rQueue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeue() {
        rQueue.dequeue();
    }

    @Test
    public void sampleDoesntDeleteElements() {
        rQueue.enqueue(5);

        rQueue.sample();
        assertEquals(new Integer(5), rQueue.sample());
    }

    @Test
    public void sizeIncreased() {
        rQueue.enqueue(5);
        rQueue.enqueue(5);
        assertEquals(2, rQueue.size());
    }

    @Test
    public void sizeDecreased() {
        rQueue.enqueue(5);
        rQueue.enqueue(5);
        rQueue.dequeue();

        assertEquals(1, rQueue.size());
    }

    @Test
    public void itrHasNextFalseWhenEmpry() {
        assertFalse(rQueue.iterator().hasNext());
    }
}